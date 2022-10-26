package com.capan.truefalse.data.questions

data class QuestionApiModel(
    val id: Long?,
    val questionText: String?,
    val questionType: Int?,
    val answers: List<String>?,
    val correctAnswer: String?)
