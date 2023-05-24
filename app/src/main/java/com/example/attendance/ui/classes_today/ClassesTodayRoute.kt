package com.example.attendance.ui.classes_today

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.SnackbarHostState

@Composable
fun ClassesTodayRoute(
    classesTodayViewModel: DayClassesViewModel,
    isExpandedScreen: Boolean,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val tabContent = rememberTabContent(classesTodayViewModel)
    val (currentSection, updateSection) = rememberSaveable {
        mutableStateOf(tabContent[1].section )
    }
    ClassesTodayScreen(
        tabContent = tabContent,
        currentSection = currentSection,
        onTabChange = updateSection,
        isExpandedScreen = isExpandedScreen,
        snackbarHostState = snackbarHostState
    )
}
