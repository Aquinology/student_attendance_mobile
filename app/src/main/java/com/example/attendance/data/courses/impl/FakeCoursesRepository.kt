package com.example.attendance.data.courses.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import com.example.attendance.data.courses.CoursesRepository
import com.example.attendance.model.Course
import com.example.attendance.data.Result
import com.example.attendance.data.courses

class FakeCoursesRepository : CoursesRepository {

    override suspend fun getCourse(courseId: Int): Result<Course> {
        return withContext(Dispatchers.IO) {
            val course = courses.find { it.id == courseId }
            if (course == null) {
                Result.Error(IllegalArgumentException("Course not found"))
            } else {
                Result.Success(course)
            }
        }
    }

    override suspend fun getTeacherCourses(teacherId: Int): Result<List<Course>> {
        return withContext(Dispatchers.IO) {
            delay(800)
            val teacherCourses = courses.filter { it.teacher.id == teacherId }
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