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
    private val mostpupalar : List<MostPupalar>
):RecyclerView.Adapter<MostPopularAdapter.MovieViewHolder>(){
    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(mostpupalars : MostPupalar){
            itemView.titulo.text = mostpupalars.titulo
            itemView.info.text = mostpupalars.info
            itemView.fecha.text = mostpupalars.fecha

            Glide.with(itemView).load(IMAGE_BASE + mostpupalars.img).into(itemView.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.most_popular, parent, false)
        )
    }

    override fun getItemCount(): Int = mostpupalar.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(mostpupalar.get(position))
    }
}
