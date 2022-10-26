package com.capan.truefalse.domain.datasource

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.data.questions.toModel

import com.capan.truefalse.domain.db.question.QuestionDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuestionsLocalDataSourceImpl(private val questionDao: QuestionDao) :
    QuestionsDataSource {

    override fun fetchQuestions(): Flow<Result<List<Question>>> = flow {
        Result.success(questionDao.getQuestions().map { it.toModel() })
    }
}