package com.example.movie.services

import com.example.movie.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder()

            .addInterceptor(loggingInterceptor)
            .build()

    private val retrofit: Retrofit.Builder by lazy {

        Retrofit.Builder().apply {

            client(client)

            baseUrl(BuildConfig.BASE_URL)

            addConverterFactory(GsonConverterFactory.create())
        }

    }

    val instance: ApiService by lazy {

        retrofit
                .build()
                .create(ApiService::class.java)
    }

}