package com.example.movie.ui.vo


class DataResource<T>(val status: DataStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): DataResource<T> = DataResource(DataStatus.SUCCESS, data, null)
        fun <T> error(msg: String?, data: T?): DataResource<T> =
            DataResource(DataStatus.ERROR, data, msg)

        fun <T> loading(data: T?): DataResource<T> = DataResource(DataStatus.LOADING, data, null)
    }
}