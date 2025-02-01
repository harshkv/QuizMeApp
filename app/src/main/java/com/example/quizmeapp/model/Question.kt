package com.example.quizmeapp.model

data class QuestionItem(
    val answer: String? = null,
    val category: String? = null,
    val choices: List<String>? = null,
    val question: String? = null
)
