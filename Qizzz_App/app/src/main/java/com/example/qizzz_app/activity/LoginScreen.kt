package com.example.qizzz_app.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qizzz_app.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_screen.*

class LoginScreen: AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
        firebaseAuth= FirebaseAuth.getInstance()

        logn_btn.setOnClickListener{
            loginuser()
        }
        already_text_reg.setOnClickListener {
            val intent=Intent(this, RegistrationScreen::class.java)
            startActivity(intent)
            finish()
        }



    }
    private  fun loginuser(){
        val email:String =email_edit_login.text.toString()
        val password:String =password_edit_login.text.toString()

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(this,"Email and password isn't blank ",Toast.LENGTH_LONG).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login Succesfull", Toast.LENGTH_LONG).show()
                val intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Error creating user", Toast.LENGTH_LONG).show()
            }
        }
    }
}