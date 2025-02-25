package com.example.quizmeapp.data

data class DataOrException<T, Boolean, E : Exception>(
    var data: T? = null,
    var isLoading: Boolean? = null,
    var exception: E? = null
) {

}
