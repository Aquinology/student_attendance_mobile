package com.example.attendance.ui.courses

import androidx.compose.runtime.Composable

@Composable
fun CoursesRoute(
    coursesViewModel: CoursesViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit
) {
    CoursesScreen(
        coursesViewModel = coursesViewModel,
        isExpandedScreen = isExpandedScreen,
        openDrawer = openDrawer
    )
}
