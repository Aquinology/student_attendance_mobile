package com.example.attendance

import android.app.Application
import androidx.room.Room
import com.example.attendance.data.AppContainer
import com.example.attendance.data.AppContainerImpl
import com.example.attendance.data.api.ActivityApi
import com.example.attendance.data.attendance.AttendanceDao
import com.example.attendance.data.classes.ClassDao
import com.example.attendance.data.courses.CourseDao
import com.example.attendance.data.students.StudentDao
import com.example.attendance.data.teachers.TeacherDao
import com.facebook.stetho.Stetho
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AttendanceApplication : Application() {

    lateinit var container : AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl()

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "attendance_db"
        ).build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        teacherDao = db.teacherDao
        studentDao = db.studentDao
        courseDao = db.courseDao
        classDao = db.classDao
        attendanceDao = db.attendanceDao

        Stetho.initializeWithDefaults(this)
    }

    companion object {
        lateinit var retrofit: Retrofit
            private set

        var teacherDao: TeacherDao? = null
        var studentDao: StudentDao? = null
        var courseDao: CourseDao? = null
        var classDao: ClassDao? = null
        var attendanceDao: AttendanceDao? = null
    }
}
