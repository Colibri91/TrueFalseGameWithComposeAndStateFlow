package com.capan.truefalse.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capan.truefalse.domain.usecase.QuestionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomePageViewModel(private val questionsUseCase: QuestionUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<HomePageUIState>(HomePageUIState.Success(emptyList()))
    val uiState: StateFlow<HomePageUIState> = _uiState

    init {
        viewModelScope.launch {
            questionsUseCase(false)
                .collect { questions ->
                    when {
                        questions.isSuccess -> {
                            val list = questions.getOrNull()
                            // post on a StateFlow
                            _uiState.value = HomePageUIState.Success(list)
                        }
                        questions.isFailure -> {
                            _uiState.value = HomePageUIState.Error(Throwable("Can not fatch data"))
                            questions.exceptionOrNull()?.printStackTrace()
                        }
                    }

                }
        }
    }
}