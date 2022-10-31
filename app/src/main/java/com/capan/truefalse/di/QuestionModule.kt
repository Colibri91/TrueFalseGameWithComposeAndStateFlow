package com.capan.truefalse.di

import android.app.Application
import androidx.room.Room
import com.capan.truefalse.domain.datasource.QuestionsLocalDataSource
import com.capan.truefalse.domain.datasource.QuestionsLocalDataSourceImpl
import com.capan.truefalse.domain.datasource.QuestionsRemoteDataSource
import com.capan.truefalse.domain.datasource.QuestionsRemoteDataSourceImpl
import com.capan.truefalse.domain.db.question.QuestionDB
import com.capan.truefalse.domain.db.question.QuestionDao
import com.capan.truefalse.domain.repository.QuestionsRepositoryImpl
import com.capan.truefalse.domain.usecase.IsLocalQuestionsConsumedUseCase
import com.capan.truefalse.domain.usecase.QuestionUseCase
import com.capan.truefalse.presentation.home.HomePageViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val questionModule = module {
    factory { QuestionsLocalDataSourceImpl(get()) }
    factory { QuestionsRemoteDataSourceImpl(get()) }
    factory { QuestionsRepositoryImpl(get(),get()) }
    factory { QuestionUseCase(get()) }
    factory { IsLocalQuestionsConsumedUseCase(get()) }

    viewModel { HomePageViewModel(get()) }


    fun provideDataBase(application: Application): QuestionDB {
        return Room.databaseBuilder(application, QuestionDB::class.java, "QUESTIONDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(database: QuestionDB): QuestionDao {
        return database.questionDao
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}