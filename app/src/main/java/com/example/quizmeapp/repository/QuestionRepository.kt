package com.example.quizmeapp.repository

import android.util.Log
import com.example.quizmeapp.data.DataOrException
import com.example.quizmeapp.model.QuestionItem
import com.example.quizmeapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val questionApi: QuestionApi
) {
    private val listOfQuestions = DataOrException<List<QuestionItem>, Boolean, Exception>()
    suspend fun getAllQuestions(): DataOrException<List<QuestionItem>, Boolean, Exception> {
        try {
            listOfQuestions.isLoading = true
            listOfQuestions.data = questionApi.getAllQuestion()
            if (listOfQuestions.data?.isNotEmpty() == true) listOfQuestions.isLoading = false
        } catch (E: Exception) {
            listOfQuestions.isLoading = false
            listOfQuestions.exception = E
            Log.d("exp", E.localizedMessage)

        }
        return listOfQuestions
    }
}