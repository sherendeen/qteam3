package com.android.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answers"

    fun getQuestion():  ArrayList<Question>{
        val questionsList = myCommonData.getArray()
        return questionsList
    }

}