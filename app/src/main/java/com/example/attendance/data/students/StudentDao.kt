package com.example.attendance.data.students

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * FROM students WHERE id =:studentId")
    fun getStudent(studentId: Int): StudentEntity

    @Query("SELECT * FROM course_students WHERE course_id =:courseId")
    fun getCourseStudents(courseId: Int): List<CourseStudentsEntity>

}
