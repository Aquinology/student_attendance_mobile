package com.example.attendance.data.attendance

import com.example.attendance.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AttendanceRepository (
    private val dao: AttendanceDao
) {

    suspend fun insert(item: AttendanceEntity) {

    }

    suspend fun delete(item: AttendanceEntity) {

    }

    suspend fun delete(attendanceId: Int) {

    }

    suspend fun getAttendance(attendanceId: Int): Result<AttendanceEntity> {
        return withContext(Dispatchers.IO) {
            val attendance = dao.getAttendance(attendanceId)
            if (attendance.id == 0) {
                Result.Error(IllegalArgumentException("Attendance not found"))
            } else {
                Result.Success(attendance)
            }
        }
    }

    suspend fun getClassAttendance(classId: Int): Result<List<AttendanceEntity>> {
        return withContext(Dispatchers.IO) {
            val classAttendance = dao.getClassAttendance(classId)
            if (shouldRandomlyFail()) {
                Result.Error(IllegalStateException())
            } else {
                Result.Success(classAttendance)
            }
        }
    }

    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}
