package com.example.movie.ui.movies

import androidx.lifecycle.ViewModel
import com.example.movie.data.Movie
import com.example.movie.utils.DataMovie

class MovieViewModel : ViewModel() {

    fun getMovie(): List<Movie> = DataMovie.generateDataMovie()
}