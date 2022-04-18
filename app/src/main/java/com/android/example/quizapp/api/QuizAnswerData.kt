package com.android.example.quizapp.api

import com.google.gson.annotations.SerializedName

data class QuizAnswerData (
    @SerializedName("id")
    val id: Int,
    @SerializedName("answer")
    val body: String,
    @SerializedName("is_correct")
    val isCorrect: Boolean,
    @SerializedName("qId")
    val group: Int
    )