package com.example.qizzz_app.utils

import com.example.qizzz_app.R
import com.example.qizzz_app.utils.ColourPicker.colors

object IconPicker {
    val icons= arrayOf(
           R.drawable.icon_finder,
           R.drawable.icon_page,
           R.drawable.icon_percil,
           R.drawable.icon_scolerr,
           R.drawable.icon_parameter,
           R.drawable.icon6,
           R.drawable.icon7,
           R.drawable.icon8

    )
    var currentIcon=0
    fun getIcon(): Int {
        currentIcon=(currentIcon+1) % icons.size
        return  icons[this.currentIcon]
    }
}