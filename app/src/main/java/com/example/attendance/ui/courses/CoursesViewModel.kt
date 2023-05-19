package com.example.attendance.ui.courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.attendance.data.courses.CoursesRepository
import com.example.attendance.model.Course
import com.example.attendance.data.successOr

data class CoursesUiState(
    val courses: List<Course> = emptyList(),
    val loading: Boolean = false
)

class CoursesViewModel(
    private val coursesRepository: CoursesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CoursesUiState(loading = true))
    val uiState: StateFlow<CoursesUiState> = _uiState.asStateFlow()

    init {
        refreshAll()
    }

    private fun refreshAll() {
        _uiState.update { it.copy(loading = true) }

        viewModelScope.launch {
            val coursesDeferred = async { coursesRepository.getTeacherCourses(1) }

            val courses = coursesDeferred.await().successOr(emptyList())

            _uiState.update {
                it.copy(
                    courses = courses,
                    loading = false
                )
            }
        }
    }

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
