package com.android.example.quizapp.api

import com.google.gson.annotations.SerializedName

data class QuizAnswerData (
    @SerializedName("id")
    val id: Int,
    @SerializedName("question")
    val body: String,
    @SerializedName("optionOne")
    val optionOne: String,
    @SerializedName("optionTwo")
    val optionTwo: String,
    @SerializedName("optionThree")
    val optionThree: String,
    @SerializedName("optionFour")
    val optionFour: String,
    @SerializedName("correctAnswer")
    val correctAnswer: Int
    )



//
//val id: Int,
//val question: String,
////    val image: Int,
//val optionOne: String,
//val optionTwo: String,
//val optionThree: String,
//val optionFour: String,
//val correctAnswer: Int