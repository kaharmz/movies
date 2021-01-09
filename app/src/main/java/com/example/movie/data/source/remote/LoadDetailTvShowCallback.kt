package com.example.movie.data.source.remote


import com.example.movie.data.source.remote.response.item.TvShowItem

interface LoadDetailTvShowCallback {

    fun loadDetailTvShow(tvSHowResponse: TvShowItem)

}