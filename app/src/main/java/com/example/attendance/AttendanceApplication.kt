package com.example.attendance

import android.app.Application
import androidx.room.Room
import com.example.attendance.data.AppContainer
import com.example.attendance.data.AppContainerImpl
import com.example.attendance.data.attendance.AttendanceDao
import com.example.attendance.data.classes.ClassDao
import com.example.attendance.data.courses.CourseDao
import com.example.attendance.data.students.StudentDao
import com.example.attendance.data.teachers.TeacherDao
import com.facebook.stetho.Stetho

class AttendanceApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "attendance_db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        teacherDao = db.teacherDao
        studentDao = db.studentDao
        courseDao = db.courseDao
        classDao = db.classDao
        attendanceDao = db.attendanceDao

        Stetho.initializeWithDefaults(this)
    }

    companion object {
        var teacherDao: TeacherDao? = null
        var studentDao: StudentDao? = null
        var courseDao: CourseDao? = null
        var classDao: ClassDao? = null
        var attendanceDao: AttendanceDao? = null
    }
}
