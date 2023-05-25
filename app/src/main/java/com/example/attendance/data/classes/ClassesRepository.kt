package com.example.attendance.data.classes

import com.example.attendance.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ClassesRepository (
    private val dao: ClassDao
) {

    suspend fun getClass(classId: Int): Result<ClassEntity> {
        return withContext(Dispatchers.IO) {
            val courseClass = dao.getClass(classId)
            if (courseClass.id == 0) {
                Result.Error(IllegalArgumentException("Class not found"))
            } else {
                Result.Success(courseClass)
            }
        }
    }

    suspend fun getCourseClasses(courseId: Int): Result<List<ClassEntity>> {
        return withContext(Dispatchers.IO) {
            delay(800)
            val courseClasses = dao.getCourseClasses(courseId)
            if (shouldRandomlyFail()) {
                Result.Error(IllegalStateException())
            } else {
                Result.Success(courseClasses)
            }
        }
    }

    suspend fun getDayClasses(date: String): Result<List<ClassEntity>> {
        return withContext(Dispatchers.IO) {
            val classesToday = dao.getDayClasses(date)
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
