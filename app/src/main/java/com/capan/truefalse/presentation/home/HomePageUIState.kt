package com.capan.truefalse.presentation.home

import com.capan.truefalse.data.questions.Question

sealed class HomePageUIState {
    data class Success(val news: List<Question>?): HomePageUIState()
    data class Error(val exception: Throwable?): HomePageUIState()
}