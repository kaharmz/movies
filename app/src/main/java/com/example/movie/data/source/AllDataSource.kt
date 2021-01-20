package com.example.movie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.ui.vo.DataResource

interface AllDataSource {

    fun getAllMovie(): LiveData<DataResource<PagedList<Movie>>>

    fun getDetailMovie(idMovie: Int): LiveData<Movie>

    fun getAllTvShow(): LiveData<DataResource<PagedList<TvShow>>>

    fun getDetailTvShow(tvId: Int): LiveData<TvShow>
}