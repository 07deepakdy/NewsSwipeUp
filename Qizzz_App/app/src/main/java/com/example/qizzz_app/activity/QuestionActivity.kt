package com.example.qizzz_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qizzz_app.R
import com.example.qizzz_app.adapter.OptionAdapter
import com.example.qizzz_app.model.Questions
import com.example.qizzz_app.model.Quiz
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    var quizzes:MutableList<Quiz>? =null
    var questions:MutableMap<String, Questions>? =null
    var intex = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        setUpFirestore()
    }
    private fun setUpFirestore(){
        var firestore = FirebaseFirestore.getInstance()
        var date =intent.getStringExtra("DATE")
        if (date != null) {
             firestore.collection("quizzes").whereEqualTo("tittle", date)
                    .get()
                    .addOnSuccessListener {
                        if (it!=null && !it.isEmpty){
                            Log.d("DATA", it.toObjects(Quiz::class.java).toString())
                            quizzes =it.toObjects(Quiz::class.java)
                            questions=quizzes!![0].mquestions
                            bindView()
                        }

                    }
        }
    }

    private fun bindView() {
        previous_btn.visibility=View.GONE
        submit_btn.visibility=View.GONE
        next_btn.visibility=View.GONE

        if (intex == 1){    //First quiestion
            next_btn.visibility=View.VISIBLE
        }else if (intex ==questions!!.size){       //Last question
            submit_btn.visibility =View.VISIBLE
            previous_btn.visibility=View.VISIBLE
        }else {                                   // Middle question
            previous_btn.visibility=View.VISIBLE
            next_btn.visibility=View.VISIBLE

        }

        val questions=questions!!["question$intex"]
        questions?.let {
            question_text.text =it.mdescription
            val optionAdapter = OptionAdapter(this,it)
            option_recyclerView.layoutManager =LinearLayoutManager(this)
            option_recyclerView.adapter=optionAdapter
            option_recyclerView.setHasFixedSize(true)
        }
    }
}