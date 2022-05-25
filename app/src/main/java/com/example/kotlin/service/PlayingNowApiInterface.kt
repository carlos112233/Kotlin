package com.example.kotlin.service

import com.example.kotlin.models.PlayingNowResponse
import retrofit2.Call
import retrofit2.http.GET

interface PlayingNowApiInterface {
    @GET("/3/movie/now_playing?api_key=87ad7d4ea35d77c23def7a580619fb27&language=es-Es&page=1")
    fun getPlaygNowList(): Call<PlayingNowResponse>
}