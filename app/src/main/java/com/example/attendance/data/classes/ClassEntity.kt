package com.example.attendance.data.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.attendance.data.courses.CourseEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TimeEntity::class,
            parentColumns = ["id"],
            childColumns = ["time_id"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = CourseEntity::class,
            parentColumns = ["id"],
            childColumns = ["course_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    tableName = "classes"
)
data class ClassEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "course_id")
    val courseId: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time_id")
    val timeId: Int
)

@Entity(
    tableName = "times"
)
data class TimeEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String
)