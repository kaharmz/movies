package com.example.movie.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class TvShow(

        val id: Int,

        val name: String?,

        val firstAirDate: String?,

        val originalLanguage: String?,

        val popularity: Double?,

        val voteCount: Int?,

        val voteAverage: Double?,

        val overview: String?,

        val posterPath: String?,

        val backdropPath: String?,

        ) : Parcelable


