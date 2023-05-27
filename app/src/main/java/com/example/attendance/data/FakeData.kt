package com.example.attendance.data

import com.example.attendance.domain.*
import com.example.attendance.utils.Date

// Teachers
val elena = TeacherModel(
    1,
    "riabova_e@gmail.com",
    "sfjoi4iasfhs",
    "Elena",
    "Riabova"
)

// Students
val mary = StudentModel( 1, "Mary", "Glover")
val gary = StudentModel( 2, "Gary", "Lee")
val timothy = StudentModel( 3, "Timothy", "Smith")
val james = StudentModel( 4, "James", "Cooper")
val robert = StudentModel( 5, "Robert", "Steele")
val roy = StudentModel( 6, "Roy", "Richardson")
val carolyn = StudentModel( 7, "Carolyn", "Allen")
val frances = StudentModel( 8, "Frances", "Dennis")
val carol = StudentModel( 9, "Carol", "Simmons")
val aaron = StudentModel( 10, "Aaron", "Davis")

// Courses
val socialPsychology = CourseModel( 1, "Social Psychology", elena)
val personalityPsychology = CourseModel( 2, "Personality Psychology", elena)

val courses = listOf(socialPsychology, personalityPsychology)

//Times
val firstTime = Time( 1, "09:30", "10:50")
val secondTime = Time( 2, "11:05", "12:25")
val thirdTime = Time( 3, "12:55", "14:15")

// Classes
val socialPsychologyFirstClass = ClassModel( 1, socialPsychology, Date(-1), firstTime)
val socialPsychologySecondClass = ClassModel( 2, socialPsychology, Date(-1), secondTime)
val socialPsychologyThirdClass = ClassModel( 3, socialPsychology, Date(0), secondTime)
val personalityPsychologyFirstClass = ClassModel( 4, personalityPsychology, Date(0), thirdTime)
val personalityPsychologySecondClass = ClassModel( 5, personalityPsychology, Date(1), firstTime)

val classes = listOf(
    socialPsychologyFirstClass,
    socialPsychologySecondClass,
    socialPsychologyThirdClass,
    personalityPsychologyFirstClass,
    personalityPsychologySecondClass
)

// Course Students

val courseStudent1 = CourseStudentsModel(1, socialPsychology, mary)
val courseStudent2 = CourseStudentsModel(2, socialPsychology, gary)
val courseStudent3 = CourseStudentsModel(3, socialPsychology, timothy)
val courseStudent4 = CourseStudentsModel(4, socialPsychology, james)
val courseStudent5 = CourseStudentsModel(5, socialPsychology, robert)
val courseStudent6 = CourseStudentsModel(6, personalityPsychology, roy)
val courseStudent7 = CourseStudentsModel(7, personalityPsychology, carolyn)
val courseStudent8 = CourseStudentsModel(8, personalityPsychology, frances)
val courseStudent9 = CourseStudentsModel(9, personalityPsychology, carol)
val courseStudent10 = CourseStudentsModel(10, personalityPsychology, aaron)

val courseStudents = listOf(
    courseStudent1,
    courseStudent2,
    courseStudent3,
    courseStudent4,
    courseStudent5,
    courseStudent6,
    courseStudent7,
    courseStudent8,
    courseStudent9,
    courseStudent10
)

// Attendance
val attendance1 = AttendanceModel(1, Mark.Present, mary, socialPsychologyFirstClass)
val attendance2 = AttendanceModel(2, Mark.Late, gary, socialPsychologyFirstClass)
val attendance3 = AttendanceModel(3, Mark.Present, timothy, socialPsychologyFirstClass)
val attendance4 = AttendanceModel(4, Mark.Present, james, socialPsychologyFirstClass)
val attendance5 = AttendanceModel(5, Mark.Present, robert, socialPsychologyFirstClass)
val attendance6 = AttendanceModel(6, Mark.Late, roy, socialPsychologyFirstClass)
val attendance7 = AttendanceModel(7, Mark.Absent, carolyn, socialPsychologyFirstClass)
val attendance8 = AttendanceModel(8, Mark.Late, frances, socialPsychologyFirstClass)
val attendance9 = AttendanceModel(9, Mark.Absent, carol, socialPsychologyFirstClass)
val attendance10 = AttendanceModel(10, Mark.Present, aaron, socialPsychologyFirstClass)

val attendances = listOf(
    attendance1,
    attendance2,
    attendance3,
    attendance4,
    attendance5,
    attendance6,
    attendance7,
    attendance8,
    attendance9,
    attendance10,
)