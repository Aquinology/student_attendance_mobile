package com.example.attendance.model

data class Attendance (
    val id: Int,
    val mark: Mark,
    val student: Student,
    val courseClass: Class
)

enum class Mark {
    Absent,
    Late,
    Present
}