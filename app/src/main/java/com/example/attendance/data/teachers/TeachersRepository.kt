package com.example.attendance.data.teachers

import com.example.attendance.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeachersRepository (
    private val dao: TeacherDao
) {

    suspend fun getTeacher(teacherId: Int): Result<TeacherEntity> {
        return withContext(Dispatchers.IO) {
            val teacher = dao.getTeacher(teacherId)
            if (teacher.id == 0) {
                Result.Error(IllegalArgumentException("Teacher not found"))
            } else {
                Result.Success(teacher)
            }
        }
    }

}