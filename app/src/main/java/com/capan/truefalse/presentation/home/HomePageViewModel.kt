package com.capan.truefalse.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capan.truefalse.domain.usecase.QuestionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomePageViewModel(private val questionsUseCase: QuestionUseCase) : ViewModel() {

   /* private val _uiState = MutableStateFlow(HomePageUIState.Success(emptyList()))
    val uiState: StateFlow<HomePageUIState> = _uiState*/

    init {
        viewModelScope.launch {
            questionsUseCase(true)
                .collect { questions ->
                    when {
                        questions.isSuccess -> {
                            val list = questions.getOrNull()
                            // post on a StateFlow
                            //_uiState.value = HomePageUIState.Success(list)
                        }
                        questions.isFailure -> {
                            questions.exceptionOrNull()?.printStackTrace()
                        }
                    }

                }
        }
    }
}