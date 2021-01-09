package com.example.movie.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(

        val id: Int,

        val title: String?,

        val releaseDate: String?,

        val originalLanguage: String?,

        val popularity: Double?,

        val voteCount: Int?,

        val voteAverage: Double?,

        val overview: String?,

        val posterPath: String?,

        val backdropPath: String?,
) : Parcelable