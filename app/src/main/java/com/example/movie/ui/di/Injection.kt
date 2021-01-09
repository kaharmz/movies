package com.example.movie.ui.di

import com.example.movie.data.source.MovieRepository
import com.example.movie.data.source.remote.RemoteDataSource


object Injection {

    fun movieRepository(): MovieRepository {
        val network = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(network)
    }
}