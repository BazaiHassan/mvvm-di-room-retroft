package com.bazai.mvvm_practice.data.repository

import com.bazai.mvvm_practice.data.db.StudentDao
import com.bazai.mvvm_practice.data.model.Student
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StudentRepository @Inject constructor(private val studentDao: StudentDao) {

    val allStudents: Flow<List<Student>> = studentDao.getAllStudents()

    suspend fun addNewStudent(student: Student) {
        studentDao.addNewStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }

    suspend fun deleteAllStudents() {
        studentDao.deleteAllStudents()
    }
}