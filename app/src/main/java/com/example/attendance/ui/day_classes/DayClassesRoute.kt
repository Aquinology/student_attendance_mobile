package com.example.attendance.ui.day_classes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.attendance.ui.courses.CoursesViewModel

@Composable
fun DayClassesRoute(
    classesTodayViewModel: DayClassesViewModel,
    coursesViewModel: CoursesViewModel,
    isExpandedScreen: Boolean
) {
    val content = rememberContent(
        classesTodayViewModel,
        coursesViewModel
    )
    val (currentSection, updateSection) = rememberSaveable {
        mutableStateOf(content[1].section )
    }
    DayClassesScreen(
        content = content,
        currentSection = currentSection,
        onTabChange = updateSection,
        isExpandedScreen = isExpandedScreen
    )
}
