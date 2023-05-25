package com.example.attendance.data.courses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CourseDao {

    @Query("SELECT * FROM courses WHERE id =:courseId")
    suspend fun getCourse(courseId: Int): CourseEntity

    @Query("SELECT * FROM courses WHERE teacher_id =:teacherId")
    suspend fun getTeacherCourses(teacherId: Int): List<CourseEntity>

}