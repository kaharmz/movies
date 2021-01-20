package com.example.movie.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.data.source.remote.response.item.MoviesItem
import com.example.movie.data.source.remote.response.item.TvShowItem
import com.example.movie.data.source.remote.vo.ApiResponse
import com.example.movie.services.ApiService
import com.example.movie.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getMovies(): LiveData<ApiResponse<List<MoviesItem>>> {
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MoviesItem>>>()
        CoroutineScope(IO).launch {
            try {
                EspressoIdlingResource.increment()
                val response = apiService.getMovies().await()
                resultMovieResponse.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovieResponse.postValue(
                    ApiResponse.error(e.message.toString(), mutableListOf())
                )
            }
            EspressoIdlingResource.decrement()
        }
        return resultMovieResponse
    }

    fun getTvShow(): LiveData<ApiResponse<List<TvShowItem>>> {
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<TvShowItem>>>()
        CoroutineScope(IO).launch {
            try {
                EspressoIdlingResource.increment()
                val response = apiService.getTvShow().await()
                resultTvShowResponse.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShowResponse.postValue(
                    ApiResponse.error(e.message.toString(), mutableListOf())
                )
            }
            EspressoIdlingResource.decrement()
        }
        return resultTvShowResponse
    }
}