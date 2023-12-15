package com.bazai.mvvm_practice.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bazai.mvvm_practice.utils.Constants.DATASTORE_NAME
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(
    name = DATASTORE_NAME
)

class DatastoreRepositoryImpl @Inject constructor(private val context: Context) :
    DatastoreRepository {

    override suspend fun putString(key: String, value: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.datastore.edit { preference ->
            preference[preferenceKey] = value
        }
    }

    override suspend fun putInteger(key: String, value: Int) {
        val preferenceKey = intPreferencesKey(key)
        context.datastore.edit { preference ->
            preference[preferenceKey] = value
        }
    }

    override suspend fun getString(key: String): String? {
        return try {
            val preferenceKey = stringPreferencesKey(key)
            val preferences = context.datastore.data.first()
            preferences[preferenceKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getInteger(key: String): Int? {
        return try {
            val preferenceKey = intPreferencesKey(key)
            val preferences = context.datastore.data.first()
            preferences[preferenceKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}