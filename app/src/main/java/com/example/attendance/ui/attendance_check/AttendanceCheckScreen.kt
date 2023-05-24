package com.example.attendance.ui.attendance_check

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attendance.R
import com.example.attendance.data.courseStudents
import com.example.attendance.domain.StudentModel
import com.example.attendance.ui.theme.AttendanceTheme
import com.example.attendance.ui.components.TopBarContent

@Composable
fun AttendanceCheckScreen() {
    Row(Modifier.fillMaxSize()) {
        AttendanceCheckScreenContent()
    }
}

@Composable
private fun AttendanceCheckScreenContent() {
    Scaffold(
        topBar = {
            TopBarContent(
                title = stringResource(id = R.string.attendance_check_title)
            )
        }
    ) {
        AttendanceCheckContent()
    }
}

@Composable
private fun AttendanceCheckContent() {
    SaveButton()
}

@Composable
private fun StudentList(
    students: List<StudentModel>
) {
    LazyColumn {
        items(students) { student ->
            StudentCard(
                student = student
            )
        }
    }
}

@Composable
private fun StudentCard(
    student: StudentModel
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(vertical = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = student.first_name + " " + student.last_name,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            RadioButtonGroup()
        }
    }
}

@Composable
private fun SaveButton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /* Handle save button click */ },
            modifier = Modifier
                .height(56.dp),
            shape = RectangleShape
        ) {
            Text(
                text = "Save",
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(
    name = "Full Preview",
    showSystemUi = true
)
@Composable
private fun PreviewAttendanceCheckScreen() {
    AttendanceTheme {
        AttendanceCheckScreen()
    }
}