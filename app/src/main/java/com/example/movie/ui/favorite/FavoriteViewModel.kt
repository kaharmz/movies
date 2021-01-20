package com.example.movie.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.movie.data.source.AllRepository
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val allRepository: AllRepository) :
    ViewModel() {

    fun getListFavoriteMovie(): LiveData<PagedList<Movie>> = allRepository.getListFavoriteMovie()

    fun getListFavoriteTv(): LiveData<PagedList<TvShow>> = allRepository.getListFavoriteTvShow()

    fun setFavoriteMovie(movie: Movie) = allRepository.setFavoriteMovie(movie)

    fun setFavoriteTv(tv: TvShow) = allRepository.setFavoriteTv(tv)
}