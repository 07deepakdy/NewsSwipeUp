package com.example.recyclerview_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListAdapter(val songs:List<MyModel>): RecyclerView.Adapter<com.example.recyclerview_kotlin.ListAdapter.MyViewHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtName.text= songs[position].tittleName
        holder.txtDescription.text= songs[position].tittleDiscription
    }

    override fun getItemCount(): Int {
        return songs.size
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtName=itemView.findViewById<TextView>(R.id.name_text)
        var txtDescription=itemView.findViewById<TextView>(R.id.description_text)


    }


}





