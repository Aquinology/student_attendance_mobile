package com.example.attendance.ui.classes_today

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.attendance.R
import com.example.attendance.model.Class
import com.example.attendance.ui.components.TopBarContent
import com.example.attendance.ui.theme.AttendanceTheme

enum class Sections(@StringRes val titleResId: Int) {
    ClassesYesterday(R.string.classes_today_section_yesterday),
    ClassesToday(R.string.classes_today_section_today),
    ClassesTomorrow(R.string.classes_today_section_tomorrow)
}

class TabContent(val section: Sections, val content: @Composable () -> Unit)

@Composable
fun ClassesTodayScreen(
    tabContent: List<TabContent>,
    currentSection: Sections,
    isExpandedScreen: Boolean,
    onTabChange: (Sections) -> Unit,
    snackbarHostState: SnackbarHostState
) {
    AttendanceTheme(){
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            topBar = {
                TopBarContent(
                    title = stringResource(R.string.classes_today_title)
                )
            }
        ){ innerPadding ->
            val screenModifier = Modifier.padding(innerPadding)
            ClassesTodayScreenContent(
                currentSection, isExpandedScreen,
                onTabChange, tabContent, screenModifier
            )
        }
    }
}

@Composable
private fun ClassesTodayScreenContent(
    currentSection: Sections,
    isExpandedScreen: Boolean,
    updateSection: (Sections) -> Unit,
    tabContent: List<TabContent>,
    modifier: Modifier = Modifier
) {
    val selectedTabIndex = tabContent.indexOfFirst { it.section == currentSection }
    Column(modifier) {
        ClassesTodayTabRow(selectedTabIndex, updateSection, tabContent, isExpandedScreen)
        Divider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
        )
        Box(modifier = Modifier.weight(1f)) {
            tabContent[selectedTabIndex].content()
        }
    }
}

@Composable
private fun ClassesTodayTabRow(
    selectedTabIndex: Int,
    updateSection: (Sections) -> Unit,
    tabContent: List<TabContent>,
    isExpandedScreen: Boolean
) {
    when (isExpandedScreen) {
        false -> {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                ClassesTodayTabRowContent(selectedTabIndex, updateSection, tabContent)
            }
        }
        true -> {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                contentColor = MaterialTheme.colorScheme.primary,
                edgePadding = 0.dp
            ) {
                ClassesTodayTabRowContent(
                    selectedTabIndex = selectedTabIndex,
                    updateSection = updateSection,
                    tabContent = tabContent,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun ClassesTodayTabRowContent(
    selectedTabIndex: Int,
    updateSection: (Sections) -> Unit,
    tabContent: List<TabContent>,
    modifier: Modifier = Modifier
) {
    tabContent.forEachIndexed { index, content ->
        val colorText = if (selectedTabIndex == index) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        }
        Tab(
            selected = selectedTabIndex == index,
            onClick = { updateSection(content.section) },
            modifier = Modifier.heightIn(min = 48.dp)
        ) {
            Text(
                text = stringResource(id = content.section.titleResId),
                color = colorText,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.paddingFromBaseline(top = 20.dp)
            )
        }
    }
}

@Composable
fun rememberTabContent(
    classesTodayViewModel: DayClassesViewModel
): List<TabContent> {

    val uiState by classesTodayViewModel.uiState.collectAsStateWithLifecycle()

    val classesYesterday = TabContent(Sections.ClassesYesterday) {
        SectionContent(
            content = uiState.classesYesterday
        )
    }

    val classesTodaySection = TabContent(Sections.ClassesToday) {
        SectionContent(
            content = uiState.classesToday
        )
    }

    val classesTomorrow = TabContent(Sections.ClassesTomorrow) {
        SectionContent(
            content = uiState.classesTomorrow
        )
    }

    return listOf(classesYesterday, classesTodaySection, classesTomorrow)
}

@Composable
private fun SectionContent(
    content: List<Class>
) {
    LazyColumn {
        items(content) { courseClass ->
            ContentItem(courseClass)
        }
    }
}

@Composable
private fun ContentItem(
    item: Class,
    modifier: Modifier = Modifier
) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.time.start_time + "\n" + item.time.end_time,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = item.course.title,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(3f),
                style = MaterialTheme.typography.titleMedium
            )
        }
        Divider(
            modifier = modifier.padding(start = 72.dp, top = 8.dp, bottom = 8.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
        )
    }
}
