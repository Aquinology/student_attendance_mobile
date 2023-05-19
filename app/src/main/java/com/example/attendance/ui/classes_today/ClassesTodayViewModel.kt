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
import com.example.attendance.model.Class as courseClass
import com.example.attendance.data.successOr

data class ClassesTodayUiState(
    val classesToday: List<courseClass> = emptyList(),
    val loading: Boolean = false
)

class ClassesTodayViewModel(
    private val classesRepository:ClassesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ClassesTodayUiState(loading = true))
    val uiState: StateFlow<ClassesTodayUiState> = _uiState.asStateFlow()

    init {
        refreshAll()
    }

    private fun refreshAll() {
        _uiState.update { it.copy(loading = true) }

        viewModelScope.launch {
            val classesTodayDeferred = async { classesRepository.getClassesToday("01.01.2020") }

            val classesToday = classesTodayDeferred.await().successOr(emptyList())

            _uiState.update {
                it.copy(
                    classesToday = classesToday,
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
                return ClassesTodayViewModel(classesRepository) as T
            }
        }
    }
}