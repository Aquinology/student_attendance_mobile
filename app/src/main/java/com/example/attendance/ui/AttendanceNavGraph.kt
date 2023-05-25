package com.example.attendance.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attendance.data.AppContainer
import com.example.attendance.ui.day_classes.DayClassesRoute
import com.example.attendance.ui.day_classes.DayClassesViewModel
import com.example.attendance.ui.courses.CoursesRoute
import com.example.attendance.ui.courses.CoursesViewModel

@Composable
fun AttendanceNavGraph(
    appContainer: AppContainer,
    isExpandedScreen: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startDestination: String = AttendanceDestinations.CLASSES_TODAY_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AttendanceDestinations.CLASSES_TODAY_ROUTE) {
            val classesTodayViewModel: DayClassesViewModel = viewModel(
                factory = DayClassesViewModel.provideFactory(appContainer.classesRepository)
            )
            val coursesViewModel: CoursesViewModel = viewModel(
                factory = CoursesViewModel.provideFactory(appContainer.coursesRepository)
            )
            DayClassesRoute(
                classesTodayViewModel = classesTodayViewModel,
                coursesViewModel = coursesViewModel,
                isExpandedScreen = isExpandedScreen
            )
        }
        composable(AttendanceDestinations.COURSES_ROUTE) {
            val coursesViewModel: CoursesViewModel = viewModel(
                factory = CoursesViewModel.provideFactory(appContainer.coursesRepository)
            )
            CoursesRoute(
                coursesViewModel = coursesViewModel
            )
        }
    }
}
