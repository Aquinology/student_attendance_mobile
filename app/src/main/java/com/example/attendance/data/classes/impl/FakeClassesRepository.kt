package com.example.attendance.data.classes.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.attendance.data.Result
import com.example.attendance.data.classes
import com.example.attendance.data.classes.ClassesRepository
import com.example.attendance.domain.ClassModel
import kotlinx.coroutines.delay
import java.util.Date

class FakeClassesRepository : ClassesRepository {

    override suspend fun getClass(classId: Int): Result<ClassModel> {
        return withContext(Dispatchers.IO) {
            val courseClass = classes.find { it.id == classId }
            if (courseClass == null) {
                Result.Error(IllegalArgumentException("Class not found"))
            } else {
                Result.Success(courseClass)
            }
        }
    }

    override suspend fun getCourseClasses(courseId: Int): Result<List<ClassModel>> {
        return withContext(Dispatchers.IO) {
            delay(800)
            val courseClasses = classes.filter { it.course.id == courseId }
            if (shouldRandomlyFail()) {
                Result.Error(IllegalStateException())
            } else {
                Result.Success(courseClasses)
            }
        }
    }

    override suspend fun getDayClasses(date: String): Result<List<ClassModel>> {
        return withContext(Dispatchers.IO) {
            delay(800)
            val classesToday = classes.filter { it.date == date }
            if (shouldRandomlyFail()) {
                Result.Error(IllegalStateException())
            } else {
                Result.Success(classesToday)
            }
        }
    }

    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}