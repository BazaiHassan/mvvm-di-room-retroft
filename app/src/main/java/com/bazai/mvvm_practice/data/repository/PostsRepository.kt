package com.bazai.mvvm_practice.data.repository


import com.bazai.mvvm_practice.data.remote.ApiInterface
import javax.inject.Inject

class PostsRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getAllPosts() = apiInterface.getAllPosts()

}