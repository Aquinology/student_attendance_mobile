package com.example.attendance.domain

data class StudentModel (
        val id: Int,
        val first_name: String,
        val last_name: String
) : java.io.Serializable

data class CourseStudentsModel (
        val id: Int = 0,
        val courseId: CourseModel,
        val studentId: StudentModel
) : java.io.Serializable