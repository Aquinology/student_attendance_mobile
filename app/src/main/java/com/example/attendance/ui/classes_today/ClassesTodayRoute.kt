package com.example.attendance.ui.classes_today

import androidx.compose.runtime.Composable

@Composable
fun ClassesTodayRoute(
    classesTodayViewModel: ClassesTodayViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit
) {
    ClassesTodayScreen(
        classesTodayViewModel = classesTodayViewModel,
        isExpandedScreen = isExpandedScreen,
        openDrawer = openDrawer
    )
}
