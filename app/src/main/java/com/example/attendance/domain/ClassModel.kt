package com.example.attendance.domain

data class ClassModel (
    val id: Int,
    val course: CourseModel,
    val date: String,
    val time: Time
) : java.io.Serializable

data class Time (
    val id: Int,
    val start_time: String,
    val end_time: String
) : java.io.Serializable
