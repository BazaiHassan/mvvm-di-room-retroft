package com.bazai.mvvm_practice


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.bazai.mvvm_practice.data.model.Grade
import com.bazai.mvvm_practice.data.model.Posts
import com.bazai.mvvm_practice.data.model.Student
import com.bazai.mvvm_practice.ui.theme.MVVMPracticeTheme
import com.bazai.mvvm_practice.viewmodel.DatastoreViewModel
import com.bazai.mvvm_practice.viewmodel.PostsViewModel
import com.bazai.mvvm_practice.viewmodel.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /********************** Start Using Room Database ***************************/
                    val viewModel by viewModels<StudentViewModel>()

                    val std1 = Student(
                        1,
                        "حسن",
                        "بازای",
                        "6090001245",
                        Grade.ONE
                    )


                    viewModel.addNewStudent(std1)

                    LaunchedEffect(key1 = Unit) {
                        viewModel.allStudents.collectLatest { students ->
                            for (student in students) {
                                Log.d("TAG_STUDENT", student.name)
                            }
                        }
                    }

                    /********************** End Using Room Database ***************************/


                    /********************** Start Using Retrofit Responses ***************************/
                    var postList by remember {
                        mutableStateOf(emptyList<Posts>())
                    }
                    LaunchedEffect(key1 = Unit) {
                        val postViewModel by viewModels<PostsViewModel>()
                        postViewModel.getAllPostsRequest()

                        postViewModel.postList.collectLatest { posts ->
                            postList = posts
                        }
                    }

                    /********************** End Using Retrofit Responses ***************************/

                    /********************** Start Using Datastore Responses ***************************/

                    val datastoreViewModel by viewModels<DatastoreViewModel>()
                    datastoreViewModel.saveToken("kxbvkjancbdvjhscbjvbjzcjzhbjbzjvhagn321654afakjhfs")

                    LaunchedEffect(Dispatchers.Main) {
                        datastoreViewModel.userToken.collectLatest { token ->
                            Log.d("USER_TOKEN", token)
                        }
                    }

                    /********************** End Using Datastore Responses ***************************/

                }
            }

        }
        @Composable
        fun UsingHiltViewModel(viewModel: DatastoreViewModel = hiltViewModel()) {
            /***
             * Here you can use `viewModel` as easy as a piece of cake
             */
        }
    }

}




