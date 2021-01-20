package com.example.movie.services

import com.example.movie.BuildConfig
import com.example.movie.data.source.remote.response.item.MoviesItem
import com.example.movie.data.source.remote.response.item.TvShowItem
import com.example.movie.data.source.remote.response.network.MovieResponse
import com.example.movie.data.source.remote.response.network.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovies(
        @Query("api_key") key: String = BuildConfig.API_KEY,
    ): Call<MovieResponse<MoviesItem>>

    @GET("discover/tv")
    fun getTvShow(
        @Query("api_key") key: String = BuildConfig.API_KEY,
    ): Call<TvShowResponse<TvShowItem>>

}