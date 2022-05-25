package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.models.*
import com.example.kotlin.service.MostPopularApiInterface
import com.example.kotlin.service.MovieServices
import com.example.kotlin.service.PlayingNowApiInterface
import com.example.kotlin.views.MostPopularAdapter
import com.example.kotlin.views.PlayingNowAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_most_popular.layoutManager = LinearLayoutManager(this)
        rv_most_popular.setHasFixedSize(true)
        getMostPopular { movies : List<MostPupalar> ->
            rv_most_popular.adapter = MostPopularAdapter(movies)
        }
        rv_playing_now.layoutManager = LinearLayoutManager(this)
        rv_playing_now.setHasFixedSize(true)
        getPlayingNow { movies : List<PlayingNow> ->
            rv_playing_now.adapter = PlayingNowAdapter(movies)
        }
    }

    private  fun getMostPopular(callback: (List<MostPupalar>)->Unit){
        val apiService = MovieServices.getInstancia().create(MostPopularApiInterface::class.java)

        apiService.getMostPopularList().enqueue(object : Callback<MostPopularResponse> {
            override fun onResponse( call: Call<MostPopularResponse>, response: Response<MostPopularResponse>) {
               return callback(response.body()!!.results)
            }

            override fun onFailure(call: Call<MostPopularResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private  fun getPlayingNow(callback: (List<PlayingNow>)-> Unit){
        val apiServices = MovieServices.getInstancia().create(PlayingNowApiInterface::class.java)
        apiServices.getPlaygNowList().enqueue(object : Callback<PlayingNowResponse> {
            override fun onResponse( call: Call<PlayingNowResponse>, response: Response<PlayingNowResponse>) {
                return callback(response.body()!!.results)
            }

            override fun onFailure(call: Call<PlayingNowResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

