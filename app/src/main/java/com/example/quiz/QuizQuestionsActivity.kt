package com.example.quiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener{
    private var mcurrentPosition:Int=1
    private var mquestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mquestionList=Constants.getQuestions()

        SetQuestion()
        option_one_id.setOnClickListener(this)
        option_two_id.setOnClickListener(this)
        option_three_id.setOnClickListener(this)
        option_four_id.setOnClickListener(this)

        btn_submit.setOnClickListener(this)

    }
    private fun SetQuestion(){

        val question=mquestionList!![mcurrentPosition-1]

        defaultOptionsView()
        if(mcurrentPosition==mquestionList!!.size){
            btn_submit.text="FINISH"
        }else{
            btn_submit.text="SUBMIT"
        }


        progress_bar.progress=mcurrentPosition
        tv_progress.text="$mcurrentPosition"+"/"+progress_bar.max

        tv_question.text=question!!.question
        iv_image.setImageResource(question.image)
        option_one_id.text=question.optionone
        option_two_id.text=question.optiontwo
        option_three_id.text=question.optionthree
        option_four_id.text=question.optionFour

    }

    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        options.add(0,option_one_id)
        options.add(1,option_two_id)
        options.add(2,option_three_id)
        options.add(3,option_four_id)


        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_one_id->{
                selectedOptionView(option_one_id,1)
            }
            R.id.option_two_id->{
                selectedOptionView(option_two_id,2)
            }
            R.id.option_three_id->{
                selectedOptionView(option_three_id,3)
            }
            R.id.option_four_id->{
                selectedOptionView(option_four_id,4)
            }
            R.id.btn_submit->{
                if (mSelectedOptionPosition==0){
                    mcurrentPosition++

                    when{
                        mcurrentPosition<=mquestionList!!.size->{
                            SetQuestion()
                        }else->{
                            Toast.makeText(this,"you have sucessfully completed the quiz",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    val question=mquestionList?.get(mcurrentPosition-1)
                    if (question!!.correctOption!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_default_option_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctOption,R.drawable.correct_default_option_bg)
                    if(mcurrentPosition==mquestionList!!.size){
                        btn_submit.text="FINISH"
                    }
                    else{
                        btn_submit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition==0
                }
            }



        }

    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                option_one_id.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                option_two_id.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                option_three_id.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                option_four_id.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition= selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_bg)
    }
}