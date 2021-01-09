package com.example.movie.data.source

import androidx.lifecycle.LiveData
import com.example.movie.data.Movie
import com.example.movie.data.TvShow

interface MovieDataSource {

    fun getAllMovie(): LiveData<List<Movie>>

    fun getDetailMovie(idMovie: Int): LiveData<Movie>

    fun getAllTvShow(): LiveData<List<TvShow>>

    fun getDetailTvShow(tvId: Int): LiveData<TvShow>
}