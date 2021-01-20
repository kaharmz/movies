package com.example.movie.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_favorite_tv")
@Parcelize
class TvShow(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "firstAirDate")
    val firstAirDate: String?,

    @ColumnInfo(name = "originalLanguage")
    val originalLanguage: String?,

    @ColumnInfo(name = "popularity")
    val popularity: Double?,

    @ColumnInfo(name = "voteCount")
    val voteCount: Int?,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double?,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "posterPath")
    val posterPath: String?,

    @ColumnInfo(name = "backdropPath")
    val backdropPath: String?,

    @NonNull
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
) : Parcelable


