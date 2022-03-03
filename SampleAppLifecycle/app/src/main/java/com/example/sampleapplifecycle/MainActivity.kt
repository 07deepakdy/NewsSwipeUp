package com.example.sampleapplifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val TAG ="MainActivityLog"
    lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)
       button.setOnClickListener {
           startActivity(Intent(this,SecoundActivity::class.java) )

       }
    }

    override fun onStart() {
        Log.d(TAG,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"onResume")
        super.onResume()
        askPermission()
    }
    override fun onPause() {
        Log.d(TAG,"onStart")
        super.onPause()
    }
    override fun onStop() {
        Log.d(TAG,"onStart")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }
    fun askPermission(){
        Log.d(TAG,"askPermission called")
    }

}

