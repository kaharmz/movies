package com.example.movie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movie.data.Movie
import com.example.movie.data.TvShow
import com.example.movie.data.source.MovieRepository

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<Movie> = movieRepository.getDetailMovie(movieId)

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShow> = movieRepository.getDetailTvShow(tvShowId)
}