package com.example.movie.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie.data.source.AllRepository
import com.example.movie.ui.detail.DetailMovieViewModel
import com.example.movie.ui.favorite.FavoriteViewModel
import com.example.movie.ui.home.HomeViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val allRepository: AllRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(allRepository) as T
            }

            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(allRepository) as T
            }

            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(allRepository) as T
            }
            else -> throw Throwable("Unknow ViewModel class: " + modelClass.name)
        }
    }
}