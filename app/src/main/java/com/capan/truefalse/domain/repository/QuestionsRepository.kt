package com.capan.truefalse.domain.repository

import com.capan.truefalse.data.questions.Question
import kotlinx.coroutines.flow.Flow

interface QuestionsRepository {
    fun getQuestions(isLocalDataConsumed : Boolean) : Flow<Result<List<Question>>>
    fun updateQuestion(question: Question)
}