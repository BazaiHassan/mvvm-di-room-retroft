package com.bazai.mvvm_practice.data.remote

import com.bazai.mvvm_practice.data.model.Posts
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    suspend fun getAllPosts():Response<List<Posts>>
}