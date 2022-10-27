package com.capan.truefalse.domain.datasource

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.data.questions.QuestionEntity
import com.capan.truefalse.data.questions.toModel

import com.capan.truefalse.domain.db.question.QuestionDao
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuestionsLocalDataSourceImpl(private val questionDao: QuestionDao) :
    QuestionsLocalDataSource {

    override fun fetchQuestions(): Flow<Result<List<Question>>> = flow {
        Result.success(questionDao.getQuestions().map { it.toModel() })
    }

    override suspend fun updateQuestion(question: QuestionEntity) {
        questionDao.updateQuestion(question)
    }

    override fun fetchNotAnsweredOrAnsweredQuestions(isAnswered: Boolean): Flow<Result<List<Question>>> = flow {
        Result.success(questionDao.getNotAnsweredOrAnsweredQuestions().map { it.toModel() })
    }

    override suspend fun isAnyQuestionExists(): Boolean {
        return questionDao.isQuestionExists()
    }
}