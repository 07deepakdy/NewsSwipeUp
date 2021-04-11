package com.example.news_headline_retrofit.network

import com.example.news_headline_retrofit.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query




const val Base_URL ="https://newsapi.org/"
const val API_key="6547b5a12c0e42ae8ece52d39ca3dcf9"

interface NewsInterface{
    @GET("v2/top-headlines?apiKey=$API_key")
    fun  getHeadlines(@Query("country") country:String,@Query("page")page:Int) :Call<News>

}

object NewsServices {
    val newsInstances:NewsInterface

    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstances=retrofit.create(NewsInterface::class.java)
    }
}

