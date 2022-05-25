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
    private val playingNow : List<PlayingNow>,
    private val listener: OnItemClickListener
):RecyclerView.Adapter<PlayingNowAdapter.PlayingNowViewHolder>(){

   inner class  PlayingNowViewHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener{


        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(playing : PlayingNow){
            itemView.titulo.text = playing.titulo
            itemView.info.text = playing.info
            itemView.fecha.text = playing.fecha

            Glide.with(itemView).load(IMAGE_BASE + playing.img).into(itemView.img)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayingNowViewHolder {
        return PlayingNowViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.playing_now, parent, false)
        )
    }

    override fun getItemCount(): Int = playingNow.size

    override fun onBindViewHolder(holder: PlayingNowViewHolder, position: Int) {
        holder.bindMovie(playingNow.get(position))
    }
}