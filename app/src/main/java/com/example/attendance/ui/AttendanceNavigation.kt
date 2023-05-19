package com.example.attendance.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object AttendanceDestinations {
    const val CLASSES_TODAY_ROUTE = "classes"
    const val COURSES_ROUTE = "courses"
}

class AttendanceNavigationActions(navController: NavHostController) {
    val navigateToClassesToday: () -> Unit = {
        navController.navigate(AttendanceDestinations.CLASSES_TODAY_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToCourses: () -> Unit = {
        navController.navigate(AttendanceDestinations.COURSES_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
