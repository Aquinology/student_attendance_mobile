package com.example.attendance.ui.courses

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.attendance.R
import com.example.attendance.ui.components.TopBarContent
import com.example.attendance.ui.theme.AttendanceTheme

@Composable
fun CoursesScreen(
    coursesViewModel: CoursesViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit
) {
    Row(Modifier.fillMaxSize()) {
        CoursesScreenContent()
    }
}

@Composable
private fun CoursesScreenContent() {
    Scaffold(
        topBar = {
            TopBarContent(
                title = stringResource(id = R.string.courses_title)
            )
        }
    ) {
        CoursesContent()
    }
}

@Composable
private fun CoursesContent() {

}





@Preview(
    name = "Full Preview",
    showSystemUi = true
)
@Composable
private fun PreviewCoursesScreenContent() {
    AttendanceTheme {
        CoursesScreenContent()
    }
}