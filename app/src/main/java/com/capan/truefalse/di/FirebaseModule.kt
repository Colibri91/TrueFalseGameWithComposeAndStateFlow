package com.capan.truefalse.di

import com.google.firebase.database.FirebaseDatabase
import org.koin.dsl.module

val firebaseModule = module {
    single { FirebaseDatabase.getInstance() }
}