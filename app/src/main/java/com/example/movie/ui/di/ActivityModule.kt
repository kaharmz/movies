package com.example.movie.ui.di

import com.example.movie.ui.detail.DetailMovieActivity
import com.example.movie.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailMovieActivity
}