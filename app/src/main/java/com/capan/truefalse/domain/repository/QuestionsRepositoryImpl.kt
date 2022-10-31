package com.capan.truefalse.domain.repository

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.data.questions.toEntity
import com.capan.truefalse.domain.datasource.QuestionsLocalDataSource
import com.capan.truefalse.domain.datasource.QuestionsLocalDataSourceImpl
import com.capan.truefalse.domain.datasource.QuestionsRemoteDataSource
import com.capan.truefalse.domain.datasource.QuestionsRemoteDataSourceImpl
import kotlinx.coroutines.flow.*

class QuestionsRepositoryImpl(
    private val questionsLocalDataSource: QuestionsLocalDataSourceImpl,
    private val questionsRemoteDataSource: QuestionsRemoteDataSourceImpl
) {

    fun getQuestions(isLocalDataExist: Boolean): Flow<Result<List<Question>>> {
        return if (isLocalDataExist) {
            questionsLocalDataSource.fetchQuestions()
        } else {
            questionsRemoteDataSource.fetchQuestions()
        }
    }

    suspend fun updateQuestion(question: Question) {
        questionsLocalDataSource.updateQuestion(question.toEntity())
    }

    fun getNotAnsweredOrAnsweredQuestions(isAnswered: Boolean) : Flow<Result<List<Question>>> {
        return questionsLocalDataSource.fetchNotAnsweredOrAnsweredQuestions(isAnswered)
    }

    suspend fun isQuestionExists(): Boolean {
        return questionsLocalDataSource.isAnyQuestionExists()
    }
}