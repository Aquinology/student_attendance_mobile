package com.example.attendance.data.classes

import com.example.attendance.data.Result
import com.example.attendance.domain.ClassModel

interface ClassesRepository {

    suspend fun getClass(classId: Int): Result<ClassModel>

    suspend fun getCourseClasses(courseId: Int): Result<List<ClassModel>>

    suspend fun getDayClasses(date: String): Result<List<ClassModel>>
}
