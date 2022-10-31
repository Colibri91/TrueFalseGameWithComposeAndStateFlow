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
        answers = convertStringToList(answers.toString()),
        correctAnswer = correctAnswer.orEmpty()
    )

fun Question.toEntity() =
    QuestionEntity(
        id = id,
        questionText = questionText.orEmpty(),
        questionType = questionType,
        answers = answers?.let { convertListToString(it) },
        correctAnswer = correctAnswer.orEmpty()
    )

private fun convertListToString(listOfQuestion : List<String>) : String{
    var listOfQuestionStr = ""
    listOfQuestion.forEach {
        listOfQuestionStr += "||"
    }
    return listOfQuestionStr
}

private fun convertStringToList(listOfQuestionStr : String) : List<String>{
    return listOfQuestionStr.split("||")
}