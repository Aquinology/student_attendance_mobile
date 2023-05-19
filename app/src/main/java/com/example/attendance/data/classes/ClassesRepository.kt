package com.example.attendance.data.classes

import com.example.attendance.data.Result
import com.example.attendance.model.Class

interface ClassesRepository {

    suspend fun getClass(classId: Int): Result<Class>

    suspend fun getCourseClasses(courseId: Int): Result<List<Class>>

    suspend fun getClassesToday(date: String): Result<List<Class>>
}