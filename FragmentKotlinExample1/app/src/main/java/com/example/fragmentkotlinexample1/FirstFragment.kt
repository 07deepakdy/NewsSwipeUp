package com.example.fragmentkotlinexample1

import android.app.Activity
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment :Fragment(){
    lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

          val view=inflater.inflate(R.layout.fragment_first,container,false)
        communicator = activity as Communicator



        view.send_btn.setOnClickListener {
            communicator.passData(view.enterName_EditText.text.toString())

        }
        return view

    }


}