package com.example.movie.data.source.remote

import com.example.movie.data.source.remote.response.item.MoviesItem

interface LoadDetailMovieCallback {

    fun loadDetailMovie(movieResponse: MoviesItem)
}