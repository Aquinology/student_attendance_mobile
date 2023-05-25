package com.example.attendance.data.students

import com.example.attendance.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentsRepository (
    private val dao: StudentDao
) {

    suspend fun getStudent(studentId: Int): Result<StudentEntity> {
        return withContext(Dispatchers.IO) {
            val student = dao.getStudent(studentId)
            if (student.id == 0) {
                Result.Error(IllegalArgumentException("Student not found"))
            } else {
                Result.Success(student)
            }
        }
    }

    suspend fun getCourseStudents(courseId: Int): Result<List<CourseStudentsEntity>> {
        return withContext(Dispatchers.IO) {
            val courseStudents = dao.getCourseStudents(courseId)
            if (shouldRandomlyFail()) {
                Result.Error(IllegalStateException())
            } else {
                Result.Success(courseStudents)
            }
        }
    }

    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}