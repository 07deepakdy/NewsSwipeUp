package com.example.qizzz_app.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qizzz_app.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.intro_screen.*

class IntroScreen:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_screen)
        val auth=FirebaseAuth.getInstance()
        if (auth.currentUser !=null){
            Toast.makeText(this,"User is already logged in!",Toast.LENGTH_LONG).show()
            redirect("MAIN")
        }
        start_btn_intro.setOnClickListener {
            redirect("LOGIN")
        }
    }
    private  fun redirect(name:String){
        val intent=when(name){
            "LOGIN" -> Intent(this, LoginScreen::class.java)
            "MAIN" -> Intent(this, MainActivity::class.java)
            else ->throw Exception("no path exists")
        }
        startActivity(intent)
        finish()
    }
}