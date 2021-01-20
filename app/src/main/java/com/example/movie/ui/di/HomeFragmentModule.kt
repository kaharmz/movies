package com.example.movie.ui.di

import com.example.movie.ui.favorite.FavoriteFragment
import com.example.movie.ui.movies.MovieFragment
import com.example.movie.ui.tvshows.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMovie(): MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTv(): TvShowFragment

    @ContributesAndroidInjector(modules = [FavoriteFragmentModule::class])
    abstract fun contributeFavorite(): FavoriteFragment
}