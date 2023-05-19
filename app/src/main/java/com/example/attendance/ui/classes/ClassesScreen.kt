package com.example.attendance.ui.classes

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
fun ClassesScreen() {
    Row(Modifier.fillMaxSize()) {
        ClassesScreenContent()
    }
}

@Composable
private fun ClassesScreenContent() {
    Scaffold(
        topBar = {
            TopBarContent(
                title = stringResource(id = R.string.classes_title)
            )
        }
    ) {
        ClassesContent()
    }
}

@Composable
private fun ClassesContent() {

}





@Preview(
    name = "Full Preview",
    showSystemUi = true
)
@Composable
private fun PreviewClassesScreen() {
    AttendanceTheme {
        ClassesScreen()
    }
}