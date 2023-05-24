package com.example.attendance.domain

data class CourseModel (
    val id: Int,
    val title: String,
    val teacher: TeacherModel
) : java.io.Serializable