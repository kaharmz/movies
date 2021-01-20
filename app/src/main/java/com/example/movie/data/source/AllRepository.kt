package com.example.movie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movie.data.NetworkBoundResource
import com.example.movie.data.source.local.LocalDataSource
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.data.source.remote.RemoteDataSource
import com.example.movie.data.source.remote.response.item.MoviesItem
import com.example.movie.data.source.remote.response.item.TvShowItem
import com.example.movie.data.source.remote.vo.ApiResponse
import com.example.movie.ui.vo.DataResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject


class AllRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) :
    AllDataSource {

    override fun getAllMovie(): LiveData<DataResource<PagedList<Movie>>> {
        return object : NetworkBoundResource<PagedList<Movie>, List<MoviesItem>>() {
            override fun loadFromDb(): LiveData<PagedList<Movie>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<Movie>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MoviesItem>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MoviesItem>) {
                val movieList = ArrayList<Movie>()
                data.mapTo(movieList) {
                    Movie(
                        it.id,
                        it.title,
                        it.releaseDate,
                        it.originalLanguage,
                        it.popularity,
                        it.voteCount,
                        it.voteAverage,
                        it.overview,
                        it.posterPath,
                        it.backdropPath
                    )
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(idMovie: Int): LiveData<Movie> =
        localDataSource.getDetailMovie(idMovie)

    fun getListFavoriteMovie(): LiveData<PagedList<Movie>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    fun setFavoriteMovie(movie: Movie) {
        CoroutineScope(IO).launch {
            localDataSource.favoriteMovie(movie)
        }
    }

    override fun getAllTvShow(): LiveData<DataResource<PagedList<TvShow>>> {
        return object : NetworkBoundResource<PagedList<TvShow>, List<TvShowItem>>() {
            override fun loadFromDb(): LiveData<PagedList<TvShow>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowItem>>> =
                remoteDataSource.getTvShow()

            override fun saveCallResult(data: List<TvShowItem>) {
                val tvList = ArrayList<TvShow>()
                data.mapTo(tvList) {
                    TvShow(
                        it.id,
                        it.name,
                        it.firstAirDate,
                        it.originalLanguage,
                        it.popularity,
                        it.voteCount,
                        it.voteAverage,
                        it.overview,
                        it.posterPath,
                        it.backdropPath
                    )
                }
                localDataSource.insertTv(tvList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvId: Int): LiveData<TvShow> = localDataSource.getDetailTv(tvId)

    fun getListFavoriteTvShow(): LiveData<PagedList<TvShow>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteTv(), config).build()
    }

    fun setFavoriteTv(tvShow: TvShow) {
        CoroutineScope(IO).launch {
            localDataSource.favoriteTv(tvShow)
        }
    }
}