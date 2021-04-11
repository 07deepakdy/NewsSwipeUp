package com.example.news_headline_retrofit.activity

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.news_headline_retrofit.R
import com.example.news_headline_retrofit.adapter.NewsAdapter
import com.example.news_headline_retrofit.data.Article
import com.example.news_headline_retrofit.data.News
import com.example.news_headline_retrofit.network.NewsServices
import com.example.news_headline_retrofit.utils.ColourPicker

import com.littlemango.stacklayoutmanager.StackLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var adapter:NewsAdapter
    //private lateinit var mInterstitialAd: InterstitialAd
    private var articles=mutableListOf<Article>()
    var pageNum=1
    var totalResults=-1
    val TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.news_recycler)
        val cantainer:ConstraintLayout=findViewById(R.id.container_main)
        adapter=NewsAdapter(this,articles)
        recyclerView.adapter=adapter

        //adsmob
      /*  MobileAds.initialize(this)

       mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
*/



        var layoutManager=StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP)
        layoutManager.setPagerMode(true)
        layoutManager.setPagerFlingVelocity(3000)
        recyclerView.layoutManager= layoutManager
        layoutManager.setItemChangedListener(object : StackLayoutManager.ItemChangedListener {
            override fun onItemChanged(position: Int) {
                cantainer.setBackgroundColor(Color.parseColor(ColourPicker.getColour()))
                Log.d(TAG, "First Visible Item : ${layoutManager.getFirstVisibleItemPosition()}")
                Log.d(TAG, "Total count : ${layoutManager.itemCount}")
                 if (totalResults > layoutManager.itemCount && layoutManager.getFirstVisibleItemPosition() >= layoutManager.itemCount -5){
                     pageNum++
                     getNews()
                 }
            }
        })

        getNews()
    }


    private fun getNews() {
        Log.d(TAG, "request send for: ${pageNum}")
        val news=NewsServices.newsInstances.getHeadlines("in",pageNum)

        news.enqueue(object : Callback<News> {
            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                val news = response?.body()
                if (news != null) {
                    Log.d("checking", news.toString())
                    totalResults=news.totalResults
                    articles.addAll(news.articles)

                    adapter.notifyDataSetChanged()

                }


            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.d("NewsCheck", "Error in fetching News: ", t)
            }

        })
    }
}




