package com.android.example.quizapp.api

import retrofit2.Call
import retrofit2.http.GET

interface QuizService {

    @GET("samplequestions")
    fun ApiAnswers(): Call<List<QuizAnswerData>>
}