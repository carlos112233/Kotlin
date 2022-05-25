package com.example.kotlin.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieServices {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org"
        private var retrofit: Retrofit? = null

        fun getInstancia(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }

    }
}