package com.bazai.mvvm_practice.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bazai.mvvm_practice.utils.Constants.STUDENT_TABLE

@Entity(tableName = STUDENT_TABLE)
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    val name:String,
    val family:String,
    val nationalCode:String,
    val grad:Grade
)
