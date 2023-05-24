package com.example.attendance.domain

data class AttendanceModel (
    val id: Int,
    val mark: Mark,
    val student: StudentModel,
    val courseClass: ClassModel
) : java.io.Serializable

enum class Mark {
    Absent,
    Late,
    Present
}