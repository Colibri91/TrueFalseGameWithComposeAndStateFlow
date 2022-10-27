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

    override fun getQuestions(isLocalDataExist: Boolean): Flow<Result<List<Question>>> {
        return if (isLocalDataExist) {
            questionsLocalDataSource.fetchQuestions()
        } else {
            questionsRemoteDataSource.fetchQuestions()
        }
    }

    override suspend fun updateQuestion(question: Question) {
        questionsLocalDataSource.updateQuestion(question.toEntity())
    }

    override fun getNotAnsweredOrAnsweredQuestions(isAnswered: Boolean) : Flow<Result<List<Question>>> {
        return questionsLocalDataSource.fetchNotAnsweredOrAnsweredQuestions(isAnswered)
    }

    override suspend fun isQuestionExists(): Boolean {
        return questionsLocalDataSource.isAnyQuestionExists()
    }
}