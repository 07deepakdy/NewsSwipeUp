package com.example.sharedpreffkotlinex

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        enter_btn.setOnClickListener {
            saveData()
        }

        loadData()

    }

    private fun saveData() {
       val inserted_edit = enter_edit.text.toString()
        show_text.text = inserted_edit
        val sharedPreferences=getSharedPreferences("SharedPreff", MODE_PRIVATE)
        val  editor=sharedPreferences.edit()
        editor.apply {
            putString("Setting",inserted_edit)
            putBoolean("BOOLEAN", switch_show.isChecked)
        }.apply()
        Toast.makeText(this,"Data saved",Toast.LENGTH_LONG).show()
    }



    private fun loadData() {
     val sharedPreferences=getSharedPreferences("SharedPreff", MODE_PRIVATE)
        val savedString=sharedPreferences.getString("Setting",null)
       // val saveBoolean:Boolean= sharedPreferences.getBoolean("Boolean",false)
        val saveBoolean=sharedPreferences.getBoolean("BOOLEAN",false)

        show_text.text= savedString
        switch_show.isChecked= saveBoolean

    }
}

private fun SharedPreferences.Editor.putString(s: String, checked: Boolean) {

}
