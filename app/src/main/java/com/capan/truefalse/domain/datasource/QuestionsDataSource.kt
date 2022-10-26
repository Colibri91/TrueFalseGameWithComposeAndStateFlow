package com.capan.truefalse.domain.datasource

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.data.questions.QuestionEntity
import kotlinx.coroutines.flow.Flow

interface QuestionsDataSource {
    fun fetchQuestions() : Flow<Result<List<Question>>>
    fun updateQuestion(question: QuestionEntity)
}