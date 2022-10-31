package com.capan.truefalse.domain.usecase

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.domain.repository.QuestionsRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class IsLocalQuestionsConsumedUseCase(private val questionsRepository: QuestionsRepositoryImpl) {

    operator fun invoke(isAnswered : Boolean = false): Boolean {
         /*questionsRepository.getNotAnsweredOrAnsweredQuestions(isAnswered).collectLatest {
             if(it.isSuccess){
                 it.getOrElse {
                     return@getOrElse false
                 }
             }
         }*/

         return false
    }
}