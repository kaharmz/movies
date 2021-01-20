package com.example.movie.data.source.remote.response.item

import com.google.gson.annotations.SerializedName


data class TvShowItem(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("vote_count")
    val voteCount: Int,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,
)
