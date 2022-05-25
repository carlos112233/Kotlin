package com.example.kotlin.views

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin.models.MostPupalar
import com.example.kotlin.models.PlayingNow
import kotlinx.android.synthetic.main.playing_now.view.*

class MostPopularAdapter (
    private val mostpupalar : List<MostPupalar>,
    private val listener:  OnItemClickListener
):RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder>(){
    inner class MostPopularViewHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(mostpupalars : MostPupalar){
            itemView.titulo.text = mostpupalars.titulo
            itemView.info.text = mostpupalars.info
            itemView.fecha.text = mostpupalars.fecha

            Glide.with(itemView).load(IMAGE_BASE + mostpupalars.img).into(itemView.img)
        }

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.OnItemClick(position)
            }
        }
    }

    interface  OnItemClickListener{
        fun OnItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularViewHolder {
        return MostPopularViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.most_popular, parent, false)
        )
    }

    override fun getItemCount(): Int = mostpupalar.size

    override fun onBindViewHolder(holder: MostPopularViewHolder, position: Int) {
        holder.bindMovie(mostpupalar.get(position))
    }
}
