package com.example.movie.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movie.data.Movie
import com.example.movie.data.TvShow
import com.example.movie.utils.DataMovie

class DetailMovieViewModel : ViewModel() {

    private lateinit var id: String

    fun setSelectedMovie(id: String) {

        this.id = id
    }

    fun getMovie(): Movie {

        lateinit var movie: Movie

        val movies = DataMovie.generateDataMovie()

        movies
                .asSequence()

                .filter { it.id == id }

                .forEach { movie = it }

        return movie
    }

    fun getTvShow(): TvShow {

        lateinit var tvShow: TvShow

        val tvShows = DataMovie.generateDataTvShow()

        tvShows
                .asSequence()

                .filter { it.id == id }

                .forEach { tvShow = it }

        return tvShow
    }
}