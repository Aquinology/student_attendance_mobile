package com.example.attendance.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attendance.R
import com.example.attendance.ui.AttendanceDestinations
import com.example.attendance.ui.theme.AttendanceTheme

@Composable
fun AppNavRail(
    currentRoute: String,
    navigateToClassesToday: () -> Unit,
    navigateToCourses: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier
    ) {
        Spacer(Modifier.weight(1f))
        NavigationRailItem(
            selected = currentRoute == AttendanceDestinations.CLASSES_TODAY_ROUTE,
            onClick = navigateToClassesToday,
            icon = { Icon(
                painter = painterResource(id = R.drawable.ic_to_do_for_classes),
                contentDescription = stringResource(R.string.classes_today_title),
                modifier = Modifier.height(24.dp)
            ) },
            label = { Text(stringResource(R.string.classes_today_title)) },
            alwaysShowLabel = false
        )
        NavigationRailItem(
            selected = currentRoute == AttendanceDestinations.COURSES_ROUTE,
            onClick = navigateToCourses,
            icon = { Icon(
                painter = painterResource(id = R.drawable.ic_graduation_for_courses),
                contentDescription = stringResource(R.string.courses_title),
                modifier = Modifier.height(24.dp)
            ) },
            label = { Text(stringResource(R.string.courses_title)) },
            alwaysShowLabel = false
        )
        Spacer(Modifier.weight(1f))
    }
}

@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppNavRail() {
    AttendanceTheme() {
        AppNavRail(
            currentRoute = AttendanceDestinations.CLASSES_TODAY_ROUTE,
            navigateToClassesToday = {},
            navigateToCourses = {},
        )
    }
}
