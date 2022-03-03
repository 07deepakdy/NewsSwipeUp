package com.example.fragmentkotlinexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(),Communicator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            var firstbutton:Button=findViewById(R.id.button1)
            var secondbutton:Button=findViewById(R.id.button2)




        // insalize fragment
        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()

        supportFragmentManager.beginTransaction().apply {
         replace(R.id.frame_layout, firstFragment).commit()
        }

        firstbutton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout,firstFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        secondbutton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout,secondFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }




    }

    override fun passData(EditTextType: String) {
      val bundle=Bundle()
        bundle.putString("message",EditTextType)

        val transaction= supportFragmentManager.beginTransaction()
        val fragment_second = SecondFragment()
        fragment_second.arguments= bundle

        transaction.replace(R.id.frame_layout,fragment_second)
        transaction.commit()
    }


}