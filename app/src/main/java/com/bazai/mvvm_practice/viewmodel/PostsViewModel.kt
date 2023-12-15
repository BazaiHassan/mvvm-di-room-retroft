package com.bazai.mvvm_practice.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazai.mvvm_practice.data.model.Posts
import com.bazai.mvvm_practice.data.remote.ApiInterface
import com.bazai.mvvm_practice.data.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val repository: PostsRepository) : ViewModel() {

    val postList = MutableStateFlow<List<Posts>>(emptyList())
    val postListError = MutableStateFlow<String?>("")
    val loading = MutableStateFlow<Boolean>(true)

    fun getAllPostsRequest() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllPosts()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let { allPosts ->
                        postList.emit(allPosts)
                        postListError.emit(null)
                        loading.emit(false)
                    }
                } else {
                    postListError.value = response.message()
                    loading.emit(false)
                }
            }
        }

    }
}