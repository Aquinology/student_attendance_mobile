package com.example.attendance.ui.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberImagePainter
import com.example.attendance.AttendanceApplication.Companion.retrofit
import com.example.attendance.R
import com.example.attendance.data.ActivityResponseModel
import com.example.attendance.data.api.ActivityApi
import com.example.attendance.data.courses.CourseEntity
import com.example.attendance.ui.components.TopBarContent
import com.example.attendance.ui.theme.AttendanceTheme

class Content(val courses: List<CourseEntity>)

@Composable
fun CoursesScreen(
    content: Content
) {
    AttendanceTheme {
        Row(Modifier.fillMaxSize()) {
            CoursesScreenContent(
                content = content
            )
        }
    }
}

@Composable
private fun CoursesScreenContent(
    content: Content
) {
    Scaffold(
        topBar = {
            TopBarContent(
                title = stringResource(R.string.courses_title)
            )
        }
    ) {
        //val api = retrofit.create(ActivityApi::class.java)
        //RandomDog(api)
        CoursesList(
            courses = content.courses
        )
    }
}

@Composable
    fun RandomDog(api: ActivityApi) {
    var response by remember { mutableStateOf<ActivityResponseModel?>(null) }

        LaunchedEffect(Unit) {
            try {
                val result = api.getRandomImage()
                if (result.status == "success") {
                    response = result
                }
            } catch (e: Exception) {
                // Обработка ошибки
            }
        }

        response?.let { data ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Image(
                        painter = rememberImagePainter(data.message),
                        contentDescription = "Random Dog Image"
                    )
                }
            }
        }
}

@Composable
private fun CoursesList(
    courses: List<CourseEntity>
) {
    LazyColumn {
        items(courses) { course ->
            CourseItem(course)
        }
    }
}

@Composable
fun CourseItem(
    course: CourseEntity,
    modifier: Modifier = Modifier
) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = course.title,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                style = MaterialTheme.typography.titleMedium
            )
        }
        Divider(
            modifier = modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
        )
    }
}

@Composable
fun rememberContent(
    coursesViewModel: CoursesViewModel
): Content {

    val uiState by coursesViewModel.uiState.collectAsStateWithLifecycle()

    val courses = uiState.courses

    return Content(
        courses = courses
    )
}