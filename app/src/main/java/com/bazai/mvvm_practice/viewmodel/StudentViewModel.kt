package com.bazai.mvvm_practice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazai.mvvm_practice.data.db.SchoolDatabase
import com.bazai.mvvm_practice.data.model.Student
import com.bazai.mvvm_practice.data.repository.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(private val repository: StudentRepository) :
    ViewModel() {

    val allStudents: Flow<List<Student>> = repository.allStudents


    fun addNewStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNewStudent(student)
        }

    }

    fun updateStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStudent(student)
        }
    }

    fun deleteStudents(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStudent(student)
        }

    }

    fun deleteAllStudents() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllStudents()
        }

    }
}