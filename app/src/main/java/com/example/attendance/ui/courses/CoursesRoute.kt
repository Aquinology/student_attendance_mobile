package com.example.attendance.ui.courses

import androidx.compose.runtime.Composable

@Composable
fun CoursesRoute(
    coursesViewModel: CoursesViewModel
) {
    val content = rememberContent(coursesViewModel)

    CoursesScreen(
        content = content
    )
}
