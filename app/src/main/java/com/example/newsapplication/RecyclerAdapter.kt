package com.example.newsapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapplication.Model.Model

class RecyclerAdapter(var context: Context, modelClassArrayList : ArrayList<Model>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var modelArrayList : List<Model> = modelClassArrayList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cardView.setOnClickListener {
            var data = modelArrayList[position]
            //CardViewOnClickListener.cardOnClickListener()
            CardViewOnClickListener(context, modelArrayList[position]).cardOnClickListener()
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

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var heading : TextView = itemView.findViewById(R.id.cardHeading)
        var description : TextView = itemView.findViewById(R.id.cardDescription)
        var author : TextView = itemView.findViewById(R.id.cardView_author)
        var time : TextView = itemView.findViewById(R.id.cardView_timing)
        var image : ImageView = itemView.findViewById(R.id.card_ImageView)
        var cardView : CardView = itemView.findViewById(R.id.cardView)

    }

//    interface CardViewOnClickListener{
//        fun cardOnClickListener(url : Model)
//    }

}

    class CardViewOnClickListener(var context: Context, var url : Model){

    fun cardOnClickListener(){
        var intent = Intent(context, webView::class.java).apply {
            putExtra("url", url.url)
        }
        context.startActivity(intent)

    }
}
