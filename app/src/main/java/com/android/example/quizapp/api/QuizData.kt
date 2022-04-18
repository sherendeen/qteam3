package com.android.example.quizapp.api

import com.google.gson.annotations.SerializedName

data class QuizData (
    @SerializedName("qId")
    val qId: Int,
    @SerializedName("question")
    val question:String = ""
)