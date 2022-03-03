package com.example.sampleapplifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecoundActivity : AppCompatActivity() {
    val TAG ="SecoundActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        setContentView(R.layout.activity_secound)
    }

    override fun onResume() {
        Log.d(TAG,"onResume")
        super.onResume()
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
}