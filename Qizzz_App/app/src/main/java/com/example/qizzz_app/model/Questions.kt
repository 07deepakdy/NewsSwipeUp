package com.example.qizzz_app.model

import com.google.gson.annotations.SerializedName



data class Questions(
       @SerializedName("description")
        var mdescription:String="",
       @SerializedName("option1")
        var moption1:String=" ",
       @SerializedName("description")
        var moption2:String=" ",
       @SerializedName("description")
        var moption3:String=" ",
       @SerializedName("description")
        var moption4:String=" " ,
       @SerializedName("description")
        var manswer:String=" ",
       @SerializedName("description")
        var muserAnswer:String=" "
)