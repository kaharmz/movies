package com.example.movie.ui.di

import android.app.Application
import com.example.movie.data.source.AllRepository
import com.example.movie.data.source.local.LocalDataSource
import com.example.movie.data.source.local.room.DatabaseDao
import com.example.movie.data.source.local.room.Databases
import com.example.movie.data.source.remote.RemoteDataSource
import com.example.movie.services.ApiService
import com.example.movie.ui.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppsModule {

    companion object {

        @Singleton
        @Provides
        fun provideMovieDao(databases: Databases): DatabaseDao = databases.movieDao()

        @Singleton
        @Provides
        fun provideMovieDatabase(application: Application): Databases =
            Databases.getInstance(application)

        @Singleton
        @Provides
        fun provideLocalDataSource(databaseDao: DatabaseDao): LocalDataSource =
            LocalDataSource(databaseDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideMovieRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource,
        ): AllRepository = AllRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(allRepository: AllRepository): ViewModelFactory =
            ViewModelFactory(allRepository)
    }

}