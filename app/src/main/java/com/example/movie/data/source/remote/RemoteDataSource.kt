package com.example.movie.data.source.remote

import com.example.movie.services.ApiConfig
import com.example.movie.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {

            instance ?: RemoteDataSource()
        }
    }

    suspend fun getMovies(callback: LoadMovieCallback) {

        EspressoIdlingResource.increment()

        ApiConfig.instance.getMovies().await().results.let { movies ->

            callback.onAllMovieReceived(movies)

            EspressoIdlingResource.decrement()
        }

    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadDetailMovieCallback) {

        EspressoIdlingResource.increment()

        ApiConfig.instance.getDetailMovie(movieId).await().let { movies ->

            callback.loadDetailMovie(movies)

            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShow(callback: LoadTvShowCallback) {

        EspressoIdlingResource.increment()

        ApiConfig.instance.getTvShow().await().results.let { tvShows ->

            callback.onAllTvReceived(tvShows)

            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadDetailTvShowCallback) {

        EspressoIdlingResource.increment()

        ApiConfig.instance.getDetailTvShow(tvShowId).await().let { tvShows ->

            callback.loadDetailTvShow(tvShows)

            EspressoIdlingResource.decrement()
        }
    }
}