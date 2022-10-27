package com.capan.truefalse.domain.datasource

import com.capan.truefalse.data.questions.Question
import kotlinx.coroutines.flow.Flow

interface QuestionsRemoteDataSource {
    fun fetchQuestions() : Flow<Result<List<Question>>>
}