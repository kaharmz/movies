package com.example.movie.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow

@Database(entities = [Movie::class, TvShow::class], version = 1, exportSchema = false)

abstract class Databases : RoomDatabase() {

    abstract fun movieDao(): DatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: Databases? = null
        fun getInstance(context: Context): Databases =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    Databases::class.java,
                    "movie.db"
                ).build()
            }
    }
}