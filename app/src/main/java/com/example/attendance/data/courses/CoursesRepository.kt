package com.example.attendance.data.courses

import com.example.attendance.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoursesRepository (
    private val dao: CourseDao
){

    suspend fun getCourse(courseId: Int): Result<CourseEntity> {
        return withContext(Dispatchers.IO) {
            val course = dao.getCourse(courseId)
            if (course.id == 0) {
                Result.Error(IllegalArgumentException("Course not found"))
            } else {
                Result.Success(course)
            }
        }
    }

    suspend fun getTeacherCourses(teacherId: Int): Result<List<CourseEntity>> {
        return withContext(Dispatchers.IO) {
            val teacherCourses = dao.getTeacherCourses(teacherId)
            if (shouldRandomlyFail()) {
                Result.Error(IllegalStateException())
            } else {
                Result.Success(teacherCourses)
            }
        }
    }

    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}