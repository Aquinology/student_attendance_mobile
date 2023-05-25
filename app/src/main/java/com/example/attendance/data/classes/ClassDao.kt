package com.example.attendance.data.classes

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ClassDao {

    @Query("SELECT * FROM classes WHERE id =:classId")
    suspend fun getClass(classId: Int): ClassEntity

    @Query("SELECT * FROM classes WHERE course_id =:courseId")
    suspend fun getCourseClasses(courseId: Int): List<ClassEntity>

    @Query("SELECT * FROM classes WHERE date =:date")
    suspend fun getDayClasses(date: String): List<ClassEntity>

}