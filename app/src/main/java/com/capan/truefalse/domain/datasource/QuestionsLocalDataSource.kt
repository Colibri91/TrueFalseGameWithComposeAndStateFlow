package com.capan.truefalse.domain.datasource

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.data.questions.QuestionEntity
import kotlinx.coroutines.flow.Flow

interface QuestionsLocalDataSource {
    fun fetchQuestions() : Flow<Result<List<Question>>>
    suspend fun updateQuestion(question: QuestionEntity)
    fun fetchNotAnsweredOrAnsweredQuestions(isAnswered : Boolean = false) : Flow<Result<List<Question>>>
    suspend fun isAnyQuestionExists() : Boolean

}