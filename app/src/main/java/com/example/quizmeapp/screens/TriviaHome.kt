package com.example.quizmeapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quizmeapp.component.Questions

@Composable
fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel(), modifier: Modifier) {
    Questions(viewModel = viewModel)
}

@Preview(showBackground = true)
@Composable
fun PreviewTriviaHome() {
//    TriviaHome()
}