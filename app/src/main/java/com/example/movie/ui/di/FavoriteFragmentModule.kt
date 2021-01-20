package com.example.movie.ui.di

import com.example.movie.ui.favorite.movie.FavoriteMovieFragment
import com.example.movie.ui.favorite.tvshow.FavoriteTvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovie(): FavoriteMovieFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteTv(): FavoriteTvShowFragment
}