package com.example.movie.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movie.data.Movie
import com.example.movie.data.source.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovie(): LiveData<List<Movie>> = movieRepository.getAllMovie()
}