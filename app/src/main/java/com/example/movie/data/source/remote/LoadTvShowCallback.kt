package com.example.movie.data.source.remote

import com.example.movie.data.source.remote.response.item.TvShowItem

interface LoadTvShowCallback {

    fun onAllTvReceived(tvShowResponse: List<TvShowItem>)
}