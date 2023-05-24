package com.example.attendance.domain

data class TeacherModel (
    val id: Int,
    val email: String,
    val password: String,
    val first_name: String,
    val last_name: String
) : java.io.Serializable