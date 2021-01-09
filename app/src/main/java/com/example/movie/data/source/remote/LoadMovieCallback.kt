package com.example.movie.data.source.remote

import com.example.movie.data.source.remote.response.item.MoviesItem


interface LoadMovieCallback {

    fun onAllMovieReceived(movieResponse: List<MoviesItem>)
}