package com.example.attendance.data.courses

import com.example.attendance.data.Result
import com.example.attendance.domain.CourseModel

interface CoursesRepository {

    suspend fun getCourse(courseId: Int): Result<CourseModel>

    suspend fun getTeacherCourses(teacherId: Int): Result<List<CourseModel>>
}