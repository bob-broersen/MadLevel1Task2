package com.broersen.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.broersen.madlevel1task2.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var firstQuestion:String = ""
    private var secondQuestion:String = ""
    private var thirdQuestion:String = ""
    private var fourthQuestion:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Sets the activity layout resource file.

        binding.submit.setOnClickListener{
            firstQuestion = binding.firstQuestion.text.toString()
            secondQuestion = binding.secondQuestion.text.toString()
            thirdQuestion = binding.thirdQuestion.text.toString()
            fourthQuestion = binding.fourthQuestion.text.toString()

            if (checkNotEmpty()){
                var result:Boolean = checkAnswers()
                if(result)
                    Toast.makeText(this, getString(R.string.correct_input),Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this, getString(R.string.incorrect_input),Toast.LENGTH_LONG).show()
            }
        }
    }

    fun checkNotEmpty():Boolean{
        if (firstQuestion.isEmpty() or secondQuestion.isEmpty() or thirdQuestion.isEmpty() or fourthQuestion.isEmpty()){
            Toast.makeText(this, getString(R.string.false_input),Toast.LENGTH_LONG).show()
            return false
        } else{
            return true
        }
    }

    fun checkAnswers():Boolean{
        val answerAndQuestion = mapOf("T" to firstQuestion, "F" to secondQuestion,"F" to thirdQuestion,"F" to fourthQuestion)
        var result:Boolean = false
        for ((answer, question) in answerAndQuestion){
            if (answer == question){
                result = true
            } else{
                result = false
                break;
            }
        }
        return result;
    }
}