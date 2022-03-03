package com.example.qizzz_app.model

import com.google.gson.annotations.SerializedName


data class Quiz(
        @SerializedName("id")
        var mid:String="",
        @SerializedName("tittle")
        var mtittle:String="tittle",
        @SerializedName("questions")
        var mquestions:MutableMap<String,Questions> = mutableMapOf()            //using map from firebase lets see why we use map over here

)