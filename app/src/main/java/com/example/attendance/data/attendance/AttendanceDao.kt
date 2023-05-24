package com.example.attendance.data.attendance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import com.example.attendance.data.Result

@Dao
interface AttendanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: AttendanceEntity)

    @Delete
    fun delete(item: AttendanceEntity)

    @Query("DELETE FROM attendance WHERE id =:attendanceId")
    fun delete(attendanceId: Int)

    @Query("SELECT * FROM attendance WHERE id =:attendanceId")
    fun getAttendance(attendanceId: Int): AttendanceEntity

    @Query("SELECT * FROM attendance WHERE class_id =:classId")
    fun getClassAttendance(classId: Int): List<AttendanceEntity>

}