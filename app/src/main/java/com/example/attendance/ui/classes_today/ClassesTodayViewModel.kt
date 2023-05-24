package com.example.attendance.ui.classes_today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.attendance.data.classes.ClassesRepository
import com.example.attendance.domain.ClassModel
import com.example.attendance.data.successOr
import com.example.attendance.utils.Date

data class DayClassesUiState(
    val classesYesterday: List<ClassModel> = emptyList(),
    val classesToday: List<ClassModel> = emptyList(),
    val classesTomorrow: List<ClassModel> = emptyList(),
    val loading: Boolean = false
)

class DayClassesViewModel(
    private val classesRepository:ClassesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DayClassesUiState(loading = true))
    val uiState: StateFlow<DayClassesUiState> = _uiState.asStateFlow()

    init {
        refreshAll()
    }

    private fun refreshAll() {
        _uiState.update { it.copy(loading = true) }

        viewModelScope.launch {
            val classesYesterdayDeferred = async { classesRepository.getDayClasses(Date(-1)) }
            val classesTodayDeferred = async { classesRepository.getDayClasses(Date(0)) }
            val classesTomorrowDeferred = async { classesRepository.getDayClasses(Date(1)) }

            val classesYesterday = classesYesterdayDeferred.await().successOr(emptyList())
            val classesToday = classesTodayDeferred.await().successOr(emptyList())
            val classesTomorrow = classesTomorrowDeferred.await().successOr(emptyList())

            _uiState.update {
                it.copy(
                    classesYesterday = classesYesterday,
                    classesToday = classesToday,
                    classesTomorrow = classesTomorrow,
                    loading = false
                )
            }
        }
    }

    companion object {
        fun provideFactory(
            classesRepository: ClassesRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DayClassesViewModel(classesRepository) as T
            }
        }
    }
}
