package com.example.news_headline_retrofit.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_headline_retrofit.R
import com.example.news_headline_retrofit.activity.DetailActivity
import com.example.news_headline_retrofit.data.Article


class NewsAdapter( var context: Context,val articles: List<Article>):
    RecyclerView.Adapter<NewsAdapter.AdapterViewHolder>() {
    //private var mInterstitialAd: InterstitialAd? = null




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
    val view=LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
       val articles=articles[position]
        holder.newsTittle.text =articles.title
        holder.newsAuthor.text=articles.author
        holder.newsDescription.text=articles.description
        Glide.with(context).load(articles.urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener {
            //Toast.makeText(context,articles.title,Toast.LENGTH_LONG).show()



            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("URL",articles.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }
    class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val newsTittle=itemView.findViewById<TextView>(R.id.tittle_text)
        val newsAuthor=itemView.findViewById<TextView>(R.id.author_text)
        val newsDescription=itemView.findViewById<TextView>(R.id.description_text)
        val newsImage=itemView.findViewById<ImageView>(R.id.url_image)

    }
}


