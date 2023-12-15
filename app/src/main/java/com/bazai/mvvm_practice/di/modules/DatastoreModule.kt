package com.bazai.mvvm_practice.di.modules

import android.content.Context
import com.bazai.mvvm_practice.data.datastore.DatastoreRepository
import com.bazai.mvvm_practice.data.datastore.DatastoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    @Singleton
    @Provides
    fun provideDatastoreRepository(@ApplicationContext app: Context): DatastoreRepository =
        DatastoreRepositoryImpl(app)
}