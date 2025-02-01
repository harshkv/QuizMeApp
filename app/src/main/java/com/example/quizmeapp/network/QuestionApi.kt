package com.example.quizmeapp.network

import com.example.quizmeapp.model.QuestionItem
import retrofit2.http.GET

interface QuestionApi {

    @GET(value = "world.json")
    suspend fun getAllQuestion(): List<QuestionItem>
}