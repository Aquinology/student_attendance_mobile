package com.example.attendance.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attendance.data.AppContainer
import com.example.attendance.ui.classes_today.ClassesTodayRoute
import com.example.attendance.ui.classes_today.ClassesTodayViewModel
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
            val classesTodayViewModel: ClassesTodayViewModel = viewModel(
                factory = ClassesTodayViewModel.provideFactory(appContainer.classesRepository)
            )
            ClassesTodayRoute(
                classesTodayViewModel = classesTodayViewModel,
                isExpandedScreen = isExpandedScreen,
                openDrawer = openDrawer
            )
        }
        composable(AttendanceDestinations.COURSES_ROUTE) {
            val coursesViewModel: CoursesViewModel = viewModel(
                factory = CoursesViewModel.provideFactory(appContainer.coursesRepository)
            )
            CoursesRoute(
                coursesViewModel = coursesViewModel,
                isExpandedScreen = isExpandedScreen,
                openDrawer = openDrawer
            )
        }
    }
}
