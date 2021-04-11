package com.example.news_headline_retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.news_headline_retrofit.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detail_web:WebView=findViewById(R.id.detail_web_view)
        val detail_progress:ProgressBar=findViewById(R.id.detail_progress_bar)
        val url=intent.getStringExtra("URL")
        if (url!=null){
            detail_web.settings.javaScriptEnabled=true
            detail_web.settings.userAgentString="Mozilla/5.0 (Linux; Android 6.0.1; Moto G (4)) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Mobile Safari/537.36"
            detail_web.webViewClient=object:WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    detail_progress.visibility=View.GONE
                    detail_web.visibility=View.VISIBLE
                }
            }
            detail_web.loadUrl(url)
        }

    }
}