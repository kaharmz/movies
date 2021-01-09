package com.example.movie.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movie.data.TvShow
import com.example.movie.data.source.MovieRepository

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvSHow(): LiveData<List<TvShow>> = movieRepository.getAllTvShow()

}