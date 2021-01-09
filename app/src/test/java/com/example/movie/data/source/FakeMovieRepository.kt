package com.example.movie.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.data.Movie
import com.example.movie.data.TvShow
import com.example.movie.data.source.remote.*
import com.example.movie.data.source.remote.response.item.MoviesItem
import com.example.movie.data.source.remote.response.item.TvShowItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeMovieMovieRepository(private val remoteDataSource: RemoteDataSource) :
        MovieDataSource {

    override fun getAllMovie(): LiveData<List<Movie>> {

        val movieItems = MutableLiveData<List<Movie>>()

        CoroutineScope(Dispatchers.IO).launch {

            remoteDataSource.getMovies(object : LoadMovieCallback {

                override fun onAllMovieReceived(movieResponse: List<MoviesItem>) {

                    val movieList = ArrayList<Movie>()

                    movieResponse.mapTo(movieList) {
                        Movie(
                                it.id,
                                it.title,
                                it.releaseDate,
                                it.originalLanguage,
                                it.popularity,
                                it.voteCount,
                                it.voteAverage,
                                it.overview,
                                it.posterPath,
                                it.backdropPath
                        )
                    }
                    movieItems.postValue(movieList)
                }
            })
        }
        return movieItems
    }

    override fun getDetailMovie(idMovie: Int): LiveData<Movie> {

        val movieDetail = MutableLiveData<Movie>()

        CoroutineScope(Dispatchers.IO).launch {

            remoteDataSource.getMovieDetail(idMovie, object : LoadDetailMovieCallback {

                override fun loadDetailMovie(movieResponse: MoviesItem) {

                    val movie = Movie(
                            movieResponse.id,
                            movieResponse.title,
                            movieResponse.releaseDate,
                            movieResponse.originalLanguage,
                            movieResponse.popularity,
                            movieResponse.voteCount,
                            movieResponse.voteAverage,
                            movieResponse.overview,
                            movieResponse.posterPath,
                            movieResponse.backdropPath
                    )
                    movieDetail.postValue(movie)
                }
            })
        }
        return movieDetail
    }

    override fun getAllTvShow(): LiveData<List<TvShow>> {

        val tvShowItems = MutableLiveData<List<TvShow>>()

        CoroutineScope(Dispatchers.IO).launch {

            remoteDataSource.getTvShow(object : LoadTvShowCallback {

                override fun onAllTvReceived(tvShowResponse: List<TvShowItem>) {

                    val tvShowList = ArrayList<TvShow>()

                    tvShowResponse.mapTo(tvShowList) {
                        TvShow(
                                it.id,
                                it.name,
                                it.firstAirDate,
                                it.originalLanguage,
                                it.popularity,
                                it.voteCount,
                                it.voteAverage,
                                it.overview,
                                it.posterPath,
                                it.backdropPath
                        )
                    }
                    tvShowItems.postValue(tvShowList)
                }
            })
        }
        return tvShowItems
    }

    override fun getDetailTvShow(tvId: Int): LiveData<TvShow> {

        val tvShowDetail = MutableLiveData<TvShow>()

        CoroutineScope(Dispatchers.IO).launch {

            remoteDataSource.getTvShowDetail(tvId, object : LoadDetailTvShowCallback {

                override fun loadDetailTvShow(tvSHowResponse: TvShowItem) {

                    val tvShow = TvShow(

                            tvSHowResponse.id,
                            tvSHowResponse.name,
                            tvSHowResponse.firstAirDate,
                            tvSHowResponse.originalLanguage,
                            tvSHowResponse.popularity,
                            tvSHowResponse.voteCount,
                            tvSHowResponse.voteAverage,
                            tvSHowResponse.overview,
                            tvSHowResponse.posterPath,
                            tvSHowResponse.backdropPath
                    )
                    tvShowDetail.postValue(tvShow)
                }
            })
        }
        return tvShowDetail
    }
}