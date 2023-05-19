package com.example.attendance.ui.classes_today

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
fun ClassesTodayScreen(
    classesTodayViewModel: ClassesTodayViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit
) {
    Row(Modifier.fillMaxSize()) {
        ClassesTodayScreenContent()
    }
}

@Composable
private fun ClassesTodayScreenContent() {
    Scaffold(
        topBar = {
            TopBarContent(
                title = stringResource(id = R.string.classes_today_title)
            )
        }
    ) {
        ClassesTodayContent()
    }
}

@Composable
private fun ClassesTodayContent() {

}





@Preview(
    name = "Full Preview",
    showSystemUi = true
)
@Composable
private fun PreviewClassesTodayScreenContent() {
    AttendanceTheme {
        ClassesTodayScreenContent()
    }
}