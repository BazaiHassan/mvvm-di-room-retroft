package com.bazai.mvvm_practice.data.model


 data class Posts(

	val image: String,
	val thumbnail: String,
	val publishedAt: String,
	val id: Int,
	val title: String,
	val category: String,
	val userId: Int,
	val slug: String,
	val url: String,
	val content: String,
	val status: String,
	val updatedAt: String
)