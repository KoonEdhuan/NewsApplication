package com.example.newsapplication

import android.content.Context
import android.content.Intent
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapplication.Model.Model

class RecyclerAdapter(context : Context, modelClassArrayList : List<Model>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var context : Context = context
    var modelArrayList : List<Model> = modelClassArrayList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.recycler_item_layout, null, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        var intent: Intent = Intent(context, webView::class.java).apply {
            putExtra("url", modelArrayList.get(position).url)
            context.startActivity()
        }


        holder.time.setText(modelArrayList.get(position).publishedAt)
        holder.heading.setText(modelArrayList.get(position).title)
        holder.description.setText(modelArrayList.get(position).description)
        holder.author.setText(modelArrayList.get(position).author)
        Glide.with(context).load(modelArrayList.get(position).urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return  modelArrayList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var heading : TextView = itemView.findViewById(R.id.cardHeading)
        var description : TextView = itemView.findViewById(R.id.cardDescription)
        var author : TextView = itemView.findViewById(R.id.cardView_author)
        var category : TextView = itemView.findViewById(R.id.c)
        var time : TextView = itemView.findViewById(R.id.cardView_timing)
        var image : ImageView = itemView.findViewById(R.id.card_ImageView)
    }




}