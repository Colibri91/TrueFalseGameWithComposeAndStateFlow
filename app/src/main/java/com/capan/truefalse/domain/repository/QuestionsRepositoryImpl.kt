package com.capan.truefalse.domain.repository

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.data.questions.toEntity
import com.capan.truefalse.domain.datasource.QuestionsLocalDataSourceImpl
import com.capan.truefalse.domain.datasource.QuestionsRemoteDataSourceImpl
import kotlinx.coroutines.flow.*

class QuestionsRepositoryImpl(
    private val questionsLocalDataSource: QuestionsLocalDataSourceImpl,
    private val questionsRemoteDataSource: QuestionsRemoteDataSourceImpl
) : QuestionsRepository {

    override fun getQuestions(isLocalDataConsumed: Boolean): Flow<Result<List<Question>>> {
        return if (isLocalDataConsumed) {
            questionsRemoteDataSource.fetchQuestions()
        } else {
            questionsLocalDataSource.fetchQuestions()
        }
    }

    override fun updateQuestion(question: Question) {
        questionsRemoteDataSource.updateQuestion(question.toEntity())
    }
}