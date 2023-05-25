package com.example.attendance.data.teachers

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TeacherDao {

    @Query("SELECT * FROM teachers WHERE id =:teacherId")
    suspend fun getTeacher(teacherId: Int): TeacherEntity

}