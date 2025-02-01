package com.example.quizmeapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizmeapp.data.DataOrException
import com.example.quizmeapp.model.QuestionItem
import com.example.quizmeapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val questionRepo: QuestionRepository
) : ViewModel() {
    var data: MutableState<DataOrException<List<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, false, Exception("No data")))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.isLoading = true
            data.value = questionRepo.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.isLoading = false
            }
        }
    }

}