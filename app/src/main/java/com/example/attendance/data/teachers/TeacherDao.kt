package com.example.attendance.data.teachers

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: TeacherEntity)

    @Query("SELECT * FROM teachers WHERE id =:teacherId")
    fun getTeacher(teacherId: Int): TeacherEntity

}