package com.example.attendance.model

data class ClassesFeed(
    val classesYesterday: List<Class>,
    val classesToday: List<Class>,
    val classesTomorrow: List<Class>,
) {
    val allClasses: List<Class> =
        classesYesterday + classesToday + classesTomorrow
}