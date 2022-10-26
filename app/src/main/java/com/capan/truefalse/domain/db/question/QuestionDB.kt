package com.capan.truefalse.domain.db.question

import androidx.room.Database
import com.capan.truefalse.data.questions.QuestionEntity

@Database(entities = [QuestionEntity::class], version = 1, exportSchema = false)
abstract class QuestionDB {
    abstract val questionDao : QuestionDao
}