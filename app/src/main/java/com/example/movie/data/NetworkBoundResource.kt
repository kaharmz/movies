@file:Suppress("LeakingThis")

package com.example.movie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.movie.data.source.remote.vo.ApiResponse
import com.example.movie.data.source.remote.vo.StatusResponse
import com.example.movie.ui.vo.DataResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MediatorLiveData<DataResource<ResultType>>()

    init {
        result.value = DataResource.loading(null)
        val dataSource = loadFromDb()
        result.addSource(dataSource) { data ->
            result.removeSource(dataSource)
            if (shouldFetch(data)) fetchFromNetwork(dataSource) else result.addSource(dataSource) { newData ->
                result.value = DataResource.success(newData)
            }
        }
    }

    protected abstract fun loadFromDb(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun onFetchFailed() {}

    private fun fetchFromNetwork(dataSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        result.addSource(dataSource) { newData ->
            result.value = DataResource.loading(newData)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dataSource)
            when (response.status) {
                StatusResponse.SUCCESS ->
                    CoroutineScope(IO).launch {
                        response.body?.let { saveCallResult(it) }
                        withContext(Main) {
                            result.addSource(loadFromDb()) { newData ->
                                result.value = DataResource.success(newData)
                            }
                        }
                    }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dataSource) { newData ->
                        result.value = DataResource.error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<DataResource<ResultType>> = result
}