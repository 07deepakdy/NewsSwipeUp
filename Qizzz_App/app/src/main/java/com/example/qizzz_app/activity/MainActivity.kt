package com.example.qizzz_app.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.example.qizzz_app.R
import com.example.qizzz_app.adapter.QuizzAdapter
import com.example.qizzz_app.model.Quiz
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle:ActionBarDrawerToggle
    lateinit var adapter: QuizzAdapter
    lateinit var firestore:FirebaseFirestore
    private var quizzlist= mutableListOf<Quiz>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()


    }
    fun setUpViews(){
        setUpFirestore()
        setUpDrawerLayout()
        setUpRecyclerView()
        setUpDatePicker()
    }

    private  fun setUpDatePicker(){
        btn_date_picker.setOnClickListener {
            val datePicker =MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager,"DatePicker")
            datePicker.addOnPositiveButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)
                val dateFormatter =SimpleDateFormat("dd-mm-yyyy")
                val date =dateFormatter.format(Date(it))
                val intent = Intent (this,QuestionActivity::class.java)
                intent.putExtra("DATA",date)
                startActivity(intent)
            }
            datePicker.addOnNegativeButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)
            }
            datePicker.addOnCancelListener {
                Log.d("DATEPICKER", "Date picker is cancel")
            }
        }
    }

    private fun setUpFirestore() {
      firestore= FirebaseFirestore.getInstance()
        val collectionReference=firestore.collection("quizzes")
        collectionReference.addSnapshotListener { value, error ->
            if (value == null || error != null){
                Toast.makeText(this,"Error fetching data",Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            Log.d("DATA", value.toObjects(Quiz::class.java).toString())
            quizzlist.clear()
            quizzlist.addAll(value.toObjects(Quiz::class.java))
            adapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView(){
        adapter= QuizzAdapter(this,quizzlist)
        quiz_recyclerView.layoutManager=GridLayoutManager(this,2)
        quiz_recyclerView.adapter=adapter
    }
    private fun setUpDrawerLayout(){
        setSupportActionBar(this.app_bar)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, maindrawer, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}