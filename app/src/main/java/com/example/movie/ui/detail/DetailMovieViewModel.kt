package com.example.movie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movie.data.source.AllRepository
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow

class DetailMovieViewModel(private val movieRepository: AllRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<Movie> = movieRepository.getDetailMovie(movieId)

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShow> = movieRepository.getDetailTvShow(tvShowId)

    fun setFavoriteMovie(movie: Movie) = movieRepository.setFavoriteMovie(movie)

    fun setFavoriteTv(tv: TvShow) = movieRepository.setFavoriteTv(tv)
}