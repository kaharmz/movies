package com.example.movie

import com.example.movie.ui.di.DaggerAppsComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppsComponent.builder().application(this).build()
}