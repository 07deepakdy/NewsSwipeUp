package com.example.news_headline_retrofit.utils

object ColourPicker{
    val colors=
           arrayOf("#FFCCE5","#CCFFCC","#FF3333","#CC00CC","#00FF00","#008080","#000080","#FF7F50","#DAA520","#4682B4","#FF1493")
            //arrayOf("#3EB90F")
       var colorIndex =1
    fun getColour(): String {
        return colors[colorIndex++ % colors.size]
    }


}