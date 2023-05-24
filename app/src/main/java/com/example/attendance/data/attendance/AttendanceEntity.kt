package com.example.attendance.data.attendance

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.attendance.data.students.StudentEntity
import com.example.attendance.data.classes.ClassEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = StudentEntity::class,
            parentColumns = ["id"],
            childColumns = ["student_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ClassEntity::class,
            parentColumns = ["id"],
            childColumns = ["class_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    tableName = "attendance"
)
data class AttendanceEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "mark")
    val mark: Mark,
    @ColumnInfo(name = "student_id")
    val studentId: Int,
    @ColumnInfo(name = "class_id")
    val classId: Int
)

enum class Mark {
    Absent,
    Late,
    Present
}