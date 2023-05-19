package com.example.attendance.model

data class Class (
    val id: Int,
    val course: Course,
    val date: String,
    val time: Time
)

data class Time (
    val id: Int,
    val start_time: String,
    val end_time: String
)
