package com.example.qizzz_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qizzz_app.R
import com.example.qizzz_app.model.Questions

class OptionAdapter(val context:Context, val questions: Questions):
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {
    private var options:List<String> = listOf(questions.moption1,questions.moption2,questions.moption3,questions.moption4)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
     var view=LayoutInflater.from(context).inflate(R.layout.option_item,parent,false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
      holder.optionView.text=options[position]
        holder.itemView.setOnClickListener{
            questions.muserAnswer=options[position]
            notifyDataSetChanged()
        }
        if (questions.muserAnswer==options[position]){
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        }else{
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)
        }
    }

    override fun getItemCount(): Int {
        return  options.size
    }

    inner class OptionViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var optionView = itemView.findViewById<TextView>(R.id.option_text)
    }

}