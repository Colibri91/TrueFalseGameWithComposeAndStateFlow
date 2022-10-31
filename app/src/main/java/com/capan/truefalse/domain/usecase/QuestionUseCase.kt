package com.capan.truefalse.domain.usecase

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.domain.repository.QuestionsRepositoryImpl
import kotlinx.coroutines.flow.Flow

class QuestionUseCase(private val questionsRepository: QuestionsRepositoryImpl) {

    operator fun invoke(isLocalDataExists : Boolean): Flow<Result<List<Question>>> {
        return questionsRepository.getQuestions(isLocalDataExists)
    }

}