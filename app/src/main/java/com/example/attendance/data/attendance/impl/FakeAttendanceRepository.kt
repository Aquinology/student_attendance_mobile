package com.example.attendance.data.attendance.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import com.example.attendance.data.attendance.AttendanceRepository

@OptIn(ExperimentalCoroutinesApi::class)
class FakeAttendanceRepository : AttendanceRepository {

}