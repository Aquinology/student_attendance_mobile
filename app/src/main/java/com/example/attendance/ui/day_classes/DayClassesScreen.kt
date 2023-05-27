package com.example.attendance.ui.day_classes

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
import com.example.attendance.data.classes
import com.example.attendance.data.classes.ClassEntity
import com.example.attendance.domain.ClassModel
import com.example.attendance.ui.components.TopBarContent
import com.example.attendance.ui.courses.CoursesViewModel
import com.example.attendance.ui.theme.AttendanceTheme
import com.example.attendance.utils.Date

enum class Sections(@StringRes val titleResId: Int) {
    ClassesYesterday(R.string.classes_today_section_yesterday),
    ClassesToday(R.string.classes_today_section_today),
    ClassesTomorrow(R.string.classes_today_section_tomorrow)
}

class Content(val section: Sections, val classes: @Composable () -> Unit)

@Composable
fun DayClassesScreen(
    content: List<Content>,
    currentSection: Sections,
    isExpandedScreen: Boolean,
    onTabChange: (Sections) -> Unit
) {
    AttendanceTheme(){
        Scaffold(
            topBar = {
                TopBarContent(
                    title = stringResource(R.string.classes_today_title)
                )
            }
        ){ innerPadding ->
            val screenModifier = Modifier.padding(innerPadding)
            DayClassesScreenContent(
                content,
                currentSection,
                isExpandedScreen,
                onTabChange,
                screenModifier
            )
        }
    }
}

@Composable
private fun DayClassesScreenContent(
    content: List<Content>,
    currentSection: Sections,
    isExpandedScreen: Boolean,
    updateSection: (Sections) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedTabIndex = content.indexOfFirst { it.section == currentSection }
    Column(modifier) {
        DayClassesTabRow(
            content,
            isExpandedScreen,
            updateSection,
            selectedTabIndex
        )
        Divider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
        )
        Box(modifier = Modifier.weight(1f)) {
            content[selectedTabIndex].classes()
        }
    }
}

@Composable
private fun DayClassesTabRow(
    content: List<Content>,
    isExpandedScreen: Boolean,
    updateSection: (Sections) -> Unit,
    selectedTabIndex: Int
) {
    when (isExpandedScreen) {
        false -> {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                DayClassesTabRowContent(
                    content,
                    updateSection,
                    selectedTabIndex
                )
            }
        }
        true -> {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                contentColor = MaterialTheme.colorScheme.primary,
                edgePadding = 0.dp
            ) {
                DayClassesTabRowContent(
                    selectedTabIndex = selectedTabIndex,
                    updateSection = updateSection,
                    content = content,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun DayClassesTabRowContent(
    content: List<Content>,
    updateSection: (Sections) -> Unit,
    selectedTabIndex: Int,
    modifier: Modifier = Modifier
) {
    content.forEachIndexed { index, classes ->
        val colorText = if (selectedTabIndex == index) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        }
        Tab(
            selected = selectedTabIndex == index,
            onClick = { updateSection(classes.section) },
            modifier = Modifier.heightIn(min = 48.dp)
        ) {
            Text(
                text = stringResource(id = classes.section.titleResId),
                color = colorText,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.paddingFromBaseline(top = 20.dp)
            )
        }
    }
}

@Composable
fun rememberContent(
    classesTodayViewModel: DayClassesViewModel,
    coursesViewModel: CoursesViewModel
): List<Content> {

    val uiState by classesTodayViewModel.uiState.collectAsStateWithLifecycle()

    val classesYesterday = Content(Sections.ClassesYesterday) {
        SectionContent(
            classes = classes.filter { it.date == Date(-1) },
            courses = coursesViewModel
        )
    }

    val classesTodaySection = Content(Sections.ClassesToday) {
        SectionContent(
            classes = classes.filter { it.date == Date(0) },
            courses = coursesViewModel
        )
    }

    val classesTomorrow = Content(Sections.ClassesTomorrow) {
        SectionContent(
            classes = classes.filter { it.date == Date(1) },
            courses = coursesViewModel
        )
    }

    return listOf(classesYesterday, classesTodaySection, classesTomorrow)
}

@Composable
private fun SectionContent(
    classes: List<ClassModel>,
    courses: CoursesViewModel
) {
    LazyColumn {
        items(classes) { courseClass ->
            ContentItem(courseClass, courses)
        }
    }
}

@Composable
private fun ContentItem(
    courseClass: ClassModel,
    courses: CoursesViewModel,
    modifier: Modifier = Modifier
) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = courseClass.time.start_time + "\n" + courseClass.time.end_time,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = courseClass.course.title,
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