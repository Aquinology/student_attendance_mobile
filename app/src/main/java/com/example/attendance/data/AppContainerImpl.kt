package com.example.attendance.data

import com.example.attendance.AttendanceApplication
import com.example.attendance.data.attendance.AttendanceRepository
import com.example.attendance.data.classes.ClassesRepository
import com.example.attendance.data.courses.CoursesRepository
import com.example.attendance.data.students.StudentsRepository
import com.example.attendance.data.teachers.TeachersRepository

interface AppContainer {
    val attendanceRepository: AttendanceRepository
    val classesRepository: ClassesRepository
    val coursesRepository: CoursesRepository
    val studentsRepository: StudentsRepository
    val teachersRepository: TeachersRepository
}

class AppContainerImpl() : AppContainer {

    override val attendanceRepository: AttendanceRepository by lazy {
        AttendanceApplication.attendanceDao?.let { AttendanceRepository(it) }!!
    }

    override val classesRepository: ClassesRepository by lazy {
        AttendanceApplication.classDao?.let { ClassesRepository(it) }!!
    }

    override val coursesRepository: CoursesRepository by lazy {
        AttendanceApplication.courseDao?.let { CoursesRepository(it) }!!
    }

    override val studentsRepository: StudentsRepository by lazy {
        AttendanceApplication.studentDao?.let { StudentsRepository(it) }!!
    }

    override val teachersRepository: TeachersRepository by lazy {
        AttendanceApplication.teacherDao?.let { TeachersRepository(it) }!!
    }

}
