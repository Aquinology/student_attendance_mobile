package com.example.attendance.data.attendance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.OnConflictStrategy

@Dao
interface AttendanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: AttendanceEntity)

    @Delete
    suspend fun delete(item: AttendanceEntity)

    @Query("DELETE FROM attendance WHERE id =:attendanceId")
    suspend fun delete(attendanceId: Int)

    @Query("SELECT * FROM attendance WHERE id =:attendanceId")
    suspend fun getAttendance(attendanceId: Int): AttendanceEntity

    @Query("SELECT * FROM attendance WHERE class_id =:classId")
    suspend fun getClassAttendance(classId: Int): List<AttendanceEntity>

}