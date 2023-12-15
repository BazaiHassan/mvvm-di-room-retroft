package com.bazai.mvvm_practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazai.mvvm_practice.data.datastore.DatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatastoreViewModel @Inject constructor(private val datastoreRepository: DatastoreRepository):ViewModel() {

    companion object {
        const val USER_TOKEN = "USER_TOKEN"
    }

    fun saveToken(token:String){
        viewModelScope.launch(Dispatchers.IO) {
            datastoreRepository.putString(USER_TOKEN, token)
        }
    }

    val userToken = MutableStateFlow("")

    fun getToken(){
        viewModelScope.launch(Dispatchers.IO) {
            datastoreRepository.getString(USER_TOKEN)?.let {value->
                userToken.emit(value)
            }
        }
    }

}