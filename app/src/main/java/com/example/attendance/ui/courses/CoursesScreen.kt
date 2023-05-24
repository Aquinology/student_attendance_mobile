package com.example.attendance.ui.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attendance.AttendanceApplication
import com.example.attendance.R
import com.example.attendance.data.courses
import com.example.attendance.data.courses.CourseEntity
import com.example.attendance.data.teachers.TeacherEntity
import com.example.attendance.domain.CourseModel
import com.example.attendance.ui.theme.AttendanceTheme

@Composable
fun CoursesScreen(
    coursesViewModel: CoursesViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit
) {
    Row(Modifier.fillMaxSize()) {
        CoursesScreenContent(
            coursesViewModel = coursesViewModel,
            isExpandedScreen = isExpandedScreen,
            openDrawer = openDrawer
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CoursesScreenContent(
    coursesViewModel: CoursesViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit
) {
    Scaffold(
        topBar = {
            CoursesTopAppBar(
                isExpandedScreen = isExpandedScreen,
                openDrawer = openDrawer
            )
        }
    ) {
        CoursesList(
            courses = courses
        )
    }
}

@Composable
private fun CoursesList(
    courses: List<CourseModel>
) {
    LazyColumn {
        items(courses) { course ->
            CourseItem(course)
        }
    }
}

@Composable
fun CourseItem(course: CourseModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val entity1 = TeacherEntity(
            email = "lkjhgf",
            password = "ghjkl;",
            firstName = "sdfgh",
            lastName = "fghjk"
        )

        val entity2 = CourseEntity(
            title = "Course1",
            teacherId = 1
        )
        AttendanceApplication.teacherDao?.insert(entity1)
        AttendanceApplication.courseDao?.insert(entity2)

        val myCourse = AttendanceApplication.courseDao?.getCourse(1)
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = course.title, fontWeight = FontWeight.Bold)
            Text(text = "Students: $myCourse")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CoursesTopAppBar(
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit,
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    scrollBehavior: TopAppBarScrollBehavior? =
        TopAppBarDefaults.enterAlwaysScrollBehavior(topAppBarState)
) {
    val title = stringResource(id = R.string.courses_title)
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.ic_attendance_wordmark),
                contentDescription = title,
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
        },
        navigationIcon = {
            if (!isExpandedScreen) {
                IconButton(onClick = openDrawer) {
                    Icon(
                        painter = painterResource(R.drawable.ic_menu_for_navigation),
                        contentDescription = stringResource(R.string.cd_open_navigation_drawer),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Preview(
    name = "Full Preview",
    showSystemUi = true
)
@Composable
private fun PreviewCoursesContent() {
    AttendanceTheme {
    }
}