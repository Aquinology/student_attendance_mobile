package com.example.attendance.ui.courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.attendance.data.courses.CoursesRepository
import com.example.attendance.domain.CourseModel
import com.example.attendance.utils.ErrorMessage
import kotlinx.coroutines.flow.*
import java.util.*

sealed interface CoursesUiState {

    val isLoading: Boolean
    val errorMessages: List<ErrorMessage>

    data class NoCourses(
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>
    ) : CoursesUiState

    data class HasCourses(
        val courses: List<CourseModel>,
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>
    ) : CoursesUiState
}

private data class CoursesViewModelState(
    val courses: List<CourseModel>? = emptyList(),
    val isLoading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList()
) {
    fun toUiState(): CoursesUiState =
        if (courses == null) {
            CoursesUiState.NoCourses(
                isLoading = isLoading,
                errorMessages = errorMessages
            )
        } else {
            CoursesUiState.HasCourses(
                courses = courses,
                isLoading = isLoading,
                errorMessages = errorMessages
            )
        }
}

class CoursesViewModel(
    private val coursesRepository: CoursesRepository
) : ViewModel() {

    private val viewModelState = MutableStateFlow(CoursesViewModelState(isLoading = true))

    val uiState = viewModelState
        .map(CoursesViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    companion object {
        fun provideFactory(
            coursesRepository: CoursesRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CoursesViewModel(coursesRepository) as T
            }
        }
    }
}
