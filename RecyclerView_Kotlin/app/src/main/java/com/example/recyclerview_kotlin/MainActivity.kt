package com.example.recyclerview_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
   //private lateinit var adapter: ListAdapter
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.songList)

        val songsObjects= mutableListOf<MyModel>()
        songsObjects.add(MyModel("dil se","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("kapil se","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("dil ram","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("dil se","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("se","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("wer","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("rbgvv","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("scbshbc","ndcbshdvjhdsc jsjcj"))
        songsObjects.add(MyModel("dsabc","ndcbshdvjhdsc j cjhscuyscgsucsjcj"))
        songsObjects.add(MyModel("dsabc","ndcbshdvjhdsc j cjhscuyscgsucsjcj"))
        songsObjects.add(MyModel("dsabc","ndcbshdvjhdsc j cjhscuyscgsucsjcj"))
        songsObjects.add(MyModel("dsabc","ndcbshdvjhdsc j cjhscuyscgsucsjcj"))
        songsObjects.add(MyModel("dsabc","ndcbshdvjhdsc j cjhscuyscgsucsjcj"))
        songsObjects.add(MyModel("dsabc","ndcbshdvjhdsc j cjhscuyscgsucsjcj"))
        songsObjects.add(MyModel("dsabc","ndcbshdvjhdsc j cjhscuyscgsucsjcj"))

        recyclerView.adapter=ListAdapter(songsObjects)

        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayout.VERTICAL,false)

    }
}