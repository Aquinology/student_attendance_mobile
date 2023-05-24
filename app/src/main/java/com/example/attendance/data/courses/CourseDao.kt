package com.example.attendance.data.courses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: CourseEntity)

    @Query("SELECT * FROM courses WHERE id =:courseId")
    fun getCourse(courseId: Int): CourseEntity

    @Query("SELECT * FROM courses WHERE teacher_id =:teacherId")
    fun getTeacherCourses(teacherId: Int): List<CourseEntity>

}