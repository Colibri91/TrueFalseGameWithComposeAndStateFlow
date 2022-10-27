package com.capan.truefalse.domain.datasource

import com.capan.truefalse.data.questions.Question
import com.capan.truefalse.data.questions.QuestionApiModel
import com.capan.truefalse.data.questions.toModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow

class QuestionsRemoteDataSourceImpl(private val firebaseDatabase: FirebaseDatabase) :
    QuestionsRemoteDataSource {

    companion object {
        const val QUESTIONS_REFERENCE = "questions"
    }

    override fun fetchQuestions() = callbackFlow<Result<List<Question>>> {
        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                this@callbackFlow.trySendBlocking(Result.failure(error.toException()))
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.map { ds ->
                    ds.getValue(QuestionApiModel::class.java)
                }
                this@callbackFlow.trySendBlocking(
                    Result.success(
                        items.filterNotNull().map { it.toModel() })
                )
            }
        }
        firebaseDatabase.getReference(QUESTIONS_REFERENCE)
            .addValueEventListener(postListener)

        awaitClose {
            firebaseDatabase.getReference(QUESTIONS_REFERENCE)
                .removeEventListener(postListener)
        }
    }
}