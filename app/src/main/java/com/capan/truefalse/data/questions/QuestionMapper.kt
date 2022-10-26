package com.capan.truefalse.data.questions

fun QuestionApiModel.toModel() =
    Question(
        id = id,
        questionText = questionText.orEmpty(),
        questionType = questionType,
        answers = answers.orEmpty(),
        correctAnswer = correctAnswer.orEmpty()
    )

fun Question.toApiModel() =
    Question(
        id = id,
        questionText = questionText.orEmpty(),
        questionType = questionType,
        answers = answers.orEmpty(),
        correctAnswer = correctAnswer.orEmpty()
    )

fun QuestionEntity.toModel() =
    Question(
        id = id,
        questionText = questionText.orEmpty(),
        questionType = questionType,
        answers = answers.orEmpty(),
        correctAnswer = correctAnswer.orEmpty()
    )

fun Question.toEntity() =
    QuestionEntity(
        id = id,
        questionText = questionText.orEmpty(),
        questionType = questionType,
        answers = answers.orEmpty(),
        correctAnswer = correctAnswer.orEmpty()
    )