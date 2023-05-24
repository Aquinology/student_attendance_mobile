package com.example.attendance.data

import com.example.attendance.model.*

// Teachers
val elena = Teacher(
    1,
    "riabova_e@gmail.com",
    "sfjoi4iasfhs",
    "Elena",
    "Riabova"
)

// Students
val mary = Student( 1, "Mary", "Glover")
val gary = Student( 2, "Gary", "Lee")
val timothy = Student( 3, "Timothy", "Smith")
val james = Student( 4, "James", "Cooper")
val robert = Student( 5, "Robert", "Steele")
val roy = Student( 6, "Roy", "Richardson")
val carolyn = Student( 7, "Carolyn", "Allen")
val frances = Student( 8, "Frances", "Dennis")
val carol = Student( 9, "Carol", "Simmons")
val aaron = Student( 10, "Aaron", "Davis")

val students = listOf( mary, gary, timothy, james, robert, roy, carolyn, frances, carol, aaron)

// Courses
val socialPsychology = Course( 1, "Social Psychology", elena)
val personalityPsychology = Course( 2, "Personality Psychology", elena)

val courses = listOf(socialPsychology, personalityPsychology)

//Times
val firstTime = Time( 1, "9:30", "10:50")
val secondTime = Time( 2, "11:05", "12:25")
val thirdTime = Time( 3, "12:55", "14:15")

// Classes
val socialPsychologyFirstClass = Class( 1, socialPsychology, "01.01.2020", firstTime)
val socialPsychologySecondClass = Class( 2, socialPsychology, "01.01.2020", secondTime)
val socialPsychologyThirdClass = Class( 3, socialPsychology, "02.01.2020", secondTime)
val personalityPsychologyFirstClass = Class( 4, personalityPsychology, "02.01.2020", thirdTime)
val personalityPsychologySecondClass = Class( 5, personalityPsychology, "03.01.2020", firstTime)

val classes = listOf(
    socialPsychologyFirstClass,
    socialPsychologySecondClass,
    socialPsychologyThirdClass,
    personalityPsychologyFirstClass,
    personalityPsychologySecondClass
)

// Attendance
val attendance1 = Attendance(1, Mark.Present, mary, socialPsychologyFirstClass)
val attendance2 = Attendance(2, Mark.Late, gary, socialPsychologyFirstClass)
val attendance3 = Attendance(3, Mark.Present, timothy, socialPsychologyFirstClass)
val attendance4 = Attendance(4, Mark.Present, james, socialPsychologyFirstClass)
val attendance5 = Attendance(5, Mark.Present, robert, socialPsychologyFirstClass)
val attendance6 = Attendance(6, Mark.Late, roy, socialPsychologyFirstClass)
val attendance7 = Attendance(7, Mark.Absent, carolyn, socialPsychologyFirstClass)
val attendance8 = Attendance(8, Mark.Late, frances, socialPsychologyFirstClass)
val attendance9 = Attendance(9, Mark.Absent, carol, socialPsychologyFirstClass)
val attendance10 = Attendance(10, Mark.Present, aaron, socialPsychologyFirstClass)

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