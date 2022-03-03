package com.example.qizzz_app.utils

object ColourPicker {
    val colors= arrayOf(
            "#3EB9DF",
            "#E5EB27",
            "#EB6627",
            "#27C6EB",
            "#397BDC",
            "#B072F3",
            "#E72E22",
            "#57E741",
            "#E79441",
            "#E741B6",
            "#7741E7",
            "#41B1E7",
            "#5241E7",
            "#16C425"
    )
    var currentColorIntex=0
    fun getColor():String{
        currentColorIntex=(currentColorIntex+1) % colors.size
        return  colors[currentColorIntex]
    }
}