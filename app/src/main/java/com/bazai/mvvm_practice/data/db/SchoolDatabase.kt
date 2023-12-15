package com.bazai.mvvm_practice.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bazai.mvvm_practice.data.model.Student
import com.bazai.mvvm_practice.utils.Constants.DATABASE_NAME

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class SchoolDatabase():RoomDatabase() {

    abstract fun studentDao(): StudentDao

}