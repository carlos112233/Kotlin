package com.example.kotlin.service

import com.example.kotlin.models.MostPopularResponse
import retrofit2.Call
import retrofit2.http.GET

interface MostPopularApiInterface {
    @GET("/3/movie/popular?api_key=87ad7d4ea35d77c23def7a580619fb27")
    fun getMostPopularList(): Call<MostPopularResponse>
}