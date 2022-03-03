package com.example.qizzz_app.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.qizzz_app.R
import com.example.qizzz_app.model.Quiz
import com.example.qizzz_app.utils.ColourPicker
import com.example.qizzz_app.utils.IconPicker
import kotlinx.android.synthetic.main.quiz_item.view.*

class QuizzAdapter (val context: Context,val quizzes:List<Quiz>): RecyclerView.Adapter<QuizzAdapter.QuizzViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizzViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.quiz_item,parent,false)
        return QuizzViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizzViewHolder, position: Int) {
        holder.quizzTittle.text=quizzes[position].mtittle
        holder.quizzCardView.setCardBackgroundColor(Color.parseColor(ColourPicker.getColor()))
        holder.quizzIcon.setImageResource(IconPicker.getIcon())
        holder.itemView.setOnClickListener {
            Toast.makeText(context,quizzes[position].mtittle, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }
    inner class QuizzViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var quizzTittle:TextView =itemView.findViewById(R.id.quizz_text)
        var quizzIcon:ImageView =itemView.findViewById(R.id.quizz_icon_image)
        var quizzCardView:CardView=itemView.findViewById(R.id.card_cantainer)
    }
}