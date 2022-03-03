package com.example.qizzz_app.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qizzz_app.R.layout.activity_registration_screen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registration_screen.*
import kotlinx.android.synthetic.main.activity_registration_screen.already_text_reg
import kotlinx.android.synthetic.main.login_screen.email_edit_login
import kotlinx.android.synthetic.main.login_screen.password_edit_login


class RegistrationScreen :AppCompatActivity(){

    lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_registration_screen)

        firebaseAuth= FirebaseAuth.getInstance()


        start_btn_intro.setOnClickListener {
            signupuser()
        }
        already_text_reg.setOnClickListener {
            val intent= Intent(this, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }



    }
    private fun signupuser(){
        val email: String =email_edit_login.text.toString()
        val password: String =password_edit_login.text.toString()
        val confirm_password:String=confirm_password_edit_reg.text.toString()

         if(email.isBlank() || password.isBlank() || confirm_password.isBlank()){
             Toast.makeText(this,"Email and password can't be blank",Toast.LENGTH_LONG).show()
             return
         }
        if(password != confirm_password){
            Toast.makeText(this,"password and Confirm password dont match",Toast.LENGTH_LONG).show()
            return
        }

            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this,"Register Successfull",Toast.LENGTH_LONG)
                            val intent=Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        }else{
                            Toast.makeText(this,"Error creating user",Toast.LENGTH_LONG)
                        }
                    }




    }
}