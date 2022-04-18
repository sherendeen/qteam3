package com.android.example.quizapp.api

import retrofit2.Call
import retrofit2.http.GET

interface QuizService {

    @GET("questions")
    fun ApiQuestion(): Call<List<QuizData>>

    @GET("answers")
    fun ApiAnswers(): Call<List<QuizAnswerData>>
}