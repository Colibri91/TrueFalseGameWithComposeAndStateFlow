package com.capan.truefalse.data.questions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questionTable")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long?,
    @ColumnInfo(name = "questionText")
    val questionText: String?,
    @ColumnInfo(name = "questionType")
    val questionType: Int?,
    @ColumnInfo(name = "answers")
    val answers: String?,
    @ColumnInfo(name = "correctAnswer")
    val correctAnswer: String?,
    @ColumnInfo(name = "isAnswered")
    val isAnswered: Boolean? = false
)