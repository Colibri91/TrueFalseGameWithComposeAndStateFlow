package com.capan.truefalse.domain.db.question

import androidx.room.Query
import androidx.room.Update
import com.capan.truefalse.data.questions.QuestionEntity

interface QuestionDao {
    @Query("select * from questionTable")
    suspend fun getQuestions(): List<QuestionEntity>

    @Update
    suspend fun updateQuestion(question : QuestionEntity)
}