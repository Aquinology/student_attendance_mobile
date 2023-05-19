package com.example.attendance.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attendance.R
import com.example.attendance.ui.theme.AttendanceTheme

@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToClassesToday: () -> Unit,
    navigateToCourses: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet(modifier) {
        AttendanceLogo(
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp)
        )
        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.classes_today_title)) },
            icon = { Icon(
                painter = painterResource(id = R.drawable.ic_to_do_for_classes),
                contentDescription = null,
                modifier = Modifier.height(24.dp)
            ) },
            selected = currentRoute == AttendanceDestinations.CLASSES_TODAY_ROUTE,
            onClick = { navigateToClassesToday(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            colors = NavigationDrawerItemDefaults.colors(
                selectedBadgeColor = MaterialTheme.colorScheme.primary,
                selectedContainerColor = MaterialTheme.colorScheme.primary
            )
        )
        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.courses_title)) },
            icon = { Icon(
                painter = painterResource(id = R.drawable.ic_graduation_for_courses),
                contentDescription = null,
                modifier = Modifier.height(24.dp)
            ) },
            selected = currentRoute == AttendanceDestinations.COURSES_ROUTE,
            onClick = { navigateToCourses(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            colors = NavigationDrawerItemDefaults.colors(
                selectedBadgeColor = MaterialTheme.colorScheme.primary,
                selectedContainerColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}

@Composable
private fun AttendanceLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Icon(
            painter = painterResource(R.drawable.ic_attendance_wordmark),
            contentDescription = stringResource(R.string.app_name),
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.height(20.dp)
        )
    }
}

@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppDrawer() {
    AttendanceTheme {
        AppDrawer(
            currentRoute = AttendanceDestinations.CLASSES_TODAY_ROUTE,
            navigateToCourses = {},
            navigateToClassesToday = {},
            closeDrawer = { }
        )
    }
}
