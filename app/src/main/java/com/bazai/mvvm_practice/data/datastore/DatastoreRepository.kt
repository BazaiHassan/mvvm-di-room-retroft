package com.bazai.mvvm_practice.data.datastore

interface DatastoreRepository {

    /* Here we made datastore type-safe, You can add other types to the repository */

    suspend fun putString(key: String, value: String)
    suspend fun putInteger(key: String, value: Int)
    suspend fun getString(key: String): String?
    suspend fun getInteger(key: String): Int?

}