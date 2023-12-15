package com.bazai.mvvm_practice.di.modules

import android.content.Context
import androidx.room.Room
import com.bazai.mvvm_practice.data.db.SchoolDatabase
import com.bazai.mvvm_practice.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        SchoolDatabase::class.java,
        Constants.DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun provideDao(database: SchoolDatabase) = database.studentDao()

}
