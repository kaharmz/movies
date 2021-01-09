package com.example.movie.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie.data.source.MovieRepository
import com.example.movie.ui.detail.DetailMovieViewModel
import com.example.movie.ui.di.Injection
import com.example.movie.ui.movies.MovieViewModel
import com.example.movie.ui.tvshows.TvShowViewModel

class ViewModelFactory(private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {

        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory = instance ?: synchronized(this) {

            instance ?: ViewModelFactory(Injection.movieRepository())
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieRepository) as T
            }

            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(movieRepository) as T
            }

            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknow ViewModel class: " + modelClass.name)
        }
    }
}