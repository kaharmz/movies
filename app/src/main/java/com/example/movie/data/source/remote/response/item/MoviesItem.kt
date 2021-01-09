package com.example.movie.data.source.remote.response.item

import com.google.gson.annotations.SerializedName


data class MoviesItem(

        @SerializedName("id")
        val id: Int,

        @SerializedName("title")
        val title: String,

        @SerializedName("release_date")
        val releaseDate: String,

        @SerializedName("original_language")
        val originalLanguage: String,

        @SerializedName("popularity")
        val popularity: Double,

        @SerializedName("vote_count")
        val voteCount: Int,

        @SerializedName("vote_average")
        val voteAverage: Double,

        @SerializedName("overview")
        val overview: String,

        @SerializedName("poster_path")
        val posterPath: String,

        @SerializedName("backdrop_path")
        val backdropPath: String,


        )


