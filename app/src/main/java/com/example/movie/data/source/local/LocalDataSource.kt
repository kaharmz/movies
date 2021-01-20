package com.example.movie.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.data.source.local.room.DatabaseDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val databaseDao: DatabaseDao) {

    //Movie data source
    fun getListMovie(): DataSource.Factory<Int, Movie> = databaseDao.getAllMovie()

    fun getFavoriteMovie(): DataSource.Factory<Int, Movie> = databaseDao.getListFavoriteMovie()

    fun getDetailMovie(movieId: Int): LiveData<Movie> = databaseDao.getDetailMovieById(movieId)

    fun insertMovie(movie: List<Movie>) = databaseDao.insertMovie(movie)

    fun favoriteMovie(movie: Movie) {
        movie.favorite = !movie.favorite
        databaseDao.updateMovie(movie)
    }

    //TV Show data source
    fun getListTv(): DataSource.Factory<Int, TvShow> = databaseDao.getAllTvShow()

    fun getFavoriteTv(): DataSource.Factory<Int, TvShow> = databaseDao.getListFavoriteTvShow()

    fun getDetailTv(tvId: Int): LiveData<TvShow> = databaseDao.getDetailTvShowById(tvId)

    fun insertTv(tvShow: List<TvShow>) = databaseDao.insertTvShow(tvShow)

    fun favoriteTv(tvShow: TvShow) {
        tvShow.favorite = !tvShow.favorite
        databaseDao.updateTvShow(tvShow)
    }
}