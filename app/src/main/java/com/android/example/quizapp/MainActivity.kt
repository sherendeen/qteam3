package com.android.example.quizapp

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.example.quizapp.api.QuizAnswerData
import com.android.example.quizapp.api.QuizService
import com.android.example.quizapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setRetrofit()

        // remove UI system from
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.btnStart.setOnClickListener {
            if(binding.etName.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }



    }

    private fun setRetrofit() {

        // start retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/sherendeen/qteam3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(QuizService::class.java)

        val callAnswer: Call<List<QuizAnswerData>> = service.ApiAnswers()
        callAnswer.enqueue(object: Callback<List<QuizAnswerData>>{
            override fun onResponse(
                call: Call<List<QuizAnswerData>>,
                response: Response<List<QuizAnswerData>>
            ) {
                val result = response.body()
                if (result != null) {
                    for (i in result) {
                        var content: String = ""
                        content += "ID: " + i.id.toString() + "\n"
                        content += "Question: " + i.body.toString() + "\n"
                        content += "Option1: " + i.optionOne.toString() + "\n"
                        content += "Option2: " + i.optionTwo.toString() + "\n"
                        content += "Option3: " + i.optionThree.toString() + "\n"
                        content += "Option4: " + i.optionFour.toString() + "\n"
                        content += "Answer: " + i.correctAnswer.toString() + "\n\n"

                        // Add each question to the myCommonData
                        myCommonData.addElement(Question(i.id, i.body, i.optionOne, i.optionTwo,
                            i.optionThree, i.optionFour, i.correctAnswer))

                        binding.tvText.append(content)
                    }
                }
            }
            override fun onFailure(call: Call<List<QuizAnswerData>>, t: Throwable) {
                Log.e(TAG,"Failx2")
            }

        })
    }
}