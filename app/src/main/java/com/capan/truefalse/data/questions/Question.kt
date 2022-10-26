package com.capan.truefalse.data.questions

data class Question(
    val id: Long?,
    val questionText: String?,
    val questionType: Int?,
    val answers: List<String>?,
    val correctAnswer: String?,
    val isAnswered : Boolean? = false)
