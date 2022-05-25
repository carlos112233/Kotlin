package com.example.kotlin.views

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.models.PlayingNow
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kotlin.R
import kotlinx.android.synthetic.main.playing_now.view.*

class PlayingNowAdapter (
    private val playingNow : List<PlayingNow>
):RecyclerView.Adapter<PlayingNowAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(playing : PlayingNow){
            itemView.titulo.text = playing.titulo
            itemView.info.text = playing.info
            itemView.fecha.text = playing.fecha

            Glide.with(itemView).load(IMAGE_BASE + playing.img).into(itemView.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.playing_now, parent, false)
        )
    }

    override fun getItemCount(): Int = playingNow.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(playingNow.get(position))
    }
}