package com.example.attendance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.attendance.data.attendance.AttendanceDao
import com.example.attendance.data.attendance.AttendanceEntity
import com.example.attendance.data.classes.ClassDao
import com.example.attendance.data.classes.ClassEntity
import com.example.attendance.data.classes.TimeEntity
import com.example.attendance.data.courses.CourseDao
import com.example.attendance.data.courses.CourseEntity
import com.example.attendance.data.students.CourseStudentsEntity
import com.example.attendance.data.students.StudentDao
import com.example.attendance.data.students.StudentEntity
import com.example.attendance.data.teachers.TeacherDao
import com.example.attendance.data.teachers.TeacherEntity

@Database(
    entities = [
        TeacherEntity::class,
        StudentEntity::class,
        CourseEntity::class,
        ClassEntity::class,
        AttendanceEntity::class,
        TimeEntity::class,
        CourseStudentsEntity::class
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract val teacherDao: TeacherDao
    abstract val studentDao: StudentDao
    abstract val courseDao: CourseDao
    abstract val classDao: ClassDao
    abstract val attendanceDao: AttendanceDao

}