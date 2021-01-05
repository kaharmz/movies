package com.example.movie.ui.tvshows

import androidx.lifecycle.ViewModel
import com.example.movie.data.TvShow
import com.example.movie.utils.DataMovie

class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<TvShow> = DataMovie.generateDataTvShow()
}