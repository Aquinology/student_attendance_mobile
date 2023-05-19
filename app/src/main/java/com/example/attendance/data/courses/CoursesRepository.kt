package com.example.attendance.data.courses

import com.example.attendance.data.Result
import com.example.attendance.model.Course

interface CoursesRepository {

    suspend fun getCourse(courseId: Int): Result<Course>

    suspend fun getTeacherCourses(teacherId: Int): Result<List<Course>>
}