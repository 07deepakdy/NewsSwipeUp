package com.example.fragmentkotlinexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {
    var displayMessage:String?=""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_second, container, false)

        displayMessage=arguments?.getString("message")
        view.textshow_text.text= displayMessage
        return view
    }


}