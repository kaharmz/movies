package com.example.movie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.movie.data.source.AllRepository
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.ui.vo.DataResource
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val allRepository: AllRepository) : ViewModel() {

    fun getListMovie(): LiveData<DataResource<PagedList<Movie>>> = allRepository.getAllMovie()

    fun getListTvShow(): LiveData<DataResource<PagedList<TvShow>>> = allRepository.getAllTvShow()
}