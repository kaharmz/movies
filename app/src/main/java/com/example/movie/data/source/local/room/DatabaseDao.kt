package com.example.movie.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow

@Dao
interface DatabaseDao {

    //Movie Query
    @Query("SELECT * FROM tb_favorite_movie")
    fun getAllMovie(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM tb_favorite_movie WHERE favorite = 1")
    fun getListFavoriteMovie(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM tb_favorite_movie WHERE id = :movieId")
    fun getDetailMovieById(movieId: Int): LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = Movie::class)
    fun insertMovie(movie: List<Movie>)

    @Update(entity = Movie::class)
    fun updateMovie(movie: Movie)


    //TV Show Query
    @Query("SELECT * FROM tb_favorite_tv")
    fun getAllTvShow(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM tb_favorite_tv WHERE favorite = 1")
    fun getListFavoriteTvShow(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM tb_favorite_tv WHERE id = :tvId")
    fun getDetailTvShowById(tvId: Int): LiveData<TvShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShow::class)
    fun insertTvShow(tv: List<TvShow>)

    @Update(entity = TvShow::class)
    fun updateTvShow(tv: TvShow)

}