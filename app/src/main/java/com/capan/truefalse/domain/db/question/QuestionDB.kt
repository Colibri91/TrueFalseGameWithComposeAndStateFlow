package com.capan.truefalse.domain.db.question

import androidx.room.Database
import androidx.room.RoomDatabase
import com.capan.truefalse.data.questions.QuestionEntity

@Database(entities = [QuestionEntity::class], version = 1, exportSchema = false)
abstract class QuestionDB : RoomDatabase() {
    abstract val questionDao : QuestionDao
}