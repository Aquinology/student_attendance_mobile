package com.example.attendance.data

import android.content.Context
import com.example.attendance.data.attendance.AttendanceRepository
import com.example.attendance.data.attendance.impl.FakeAttendanceRepository
import com.example.attendance.data.classes.ClassesRepository
import com.example.attendance.data.classes.impl.FakeClassesRepository
import com.example.attendance.data.courses.CoursesRepository
import com.example.attendance.data.courses.impl.FakeCoursesRepository
import com.example.attendance.data.students.StudentsRepository
import com.example.attendance.data.students.impl.FakeStudentsRepository
import com.example.attendance.data.teachers.TeachersRepository
import com.example.attendance.data.teachers.impl.FakeTeachersRepository

interface AppContainer {
    val attendanceRepository: AttendanceRepository
    val classesRepository: ClassesRepository
    val coursesRepository: CoursesRepository
    val studentsRepository: StudentsRepository
    val teachersRepository: TeachersRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val attendanceRepository: AttendanceRepository by lazy {
        FakeAttendanceRepository()
    }

    override val classesRepository: ClassesRepository by lazy {
        FakeClassesRepository()
    }

    override val coursesRepository: CoursesRepository by lazy {
        FakeCoursesRepository()
    }

    override val studentsRepository: StudentsRepository by lazy {
        FakeStudentsRepository()
    }

    override val teachersRepository: TeachersRepository by lazy {
        FakeTeachersRepository()
    }

}
