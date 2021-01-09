package com.example.movie.data.source.remote.response.network

import com.google.gson.annotations.SerializedName


data class MovieResponse<T>(

        @SerializedName("page")
        val page: Int,

        @SerializedName("total_pages")
        val totalPages: Int,

        @SerializedName("results")
        val results: List<T>,

        @SerializedName("total_results")
        val totalResults: Int,

        )
