package com.example.movie.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.movie.data.source.local.LocalDataSource
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.data.source.remote.RemoteDataSource
import com.example.movie.ui.vo.DataResource
import com.example.movie.utils.DataMovie
import com.example.movie.utils.LiveDataTestUtil
import com.example.movie.utils.PagedListUtil
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class AllRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val allRepository = FakeAllRepository(remote, local)
    private val listMovie = DataMovie.generateRemoteDataMovie()
    private val listTv = DataMovie.generateRemoteDataTvShow()
    private val movie = DataMovie.generateDataMovie()[0]
    private val tvShow = DataMovie.generateDataTvShow()[0]

    @Test
    fun getAllMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(local.getListMovie()).thenReturn(dataSourceFactory)
        allRepository.getAllMovie()
        val movieEntities =
            DataResource.success(PagedListUtil.mockPagedList(DataMovie.generateDataMovie()))
        verify(local).getListMovie()
        assertNotNull(movieEntities.data)
        assertEquals(listMovie.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(local.getListTv()).thenReturn(dataSourceFactory)
        allRepository.getAllTvShow()
        val tvEntities =
            DataResource.success(PagedListUtil.mockPagedList(DataMovie.generateDataTvShow()))
        verify(local).getListTv()
        assertNotNull(tvEntities.data)
        assertEquals(listTv.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetailById() {
        val dataMovie = MutableLiveData<Movie>()
        dataMovie.value = movie
        `when`(local.getDetailMovie(movie.id)).thenReturn(dataMovie)
        val data = LiveDataTestUtil.getValue(allRepository.getDetailMovie(movie.id))
        verify(local).getDetailMovie(movie.id)
        assertNotNull(data)
        assertEquals(movie.id, data.id)
    }

    @Test
    fun getTvShowDetailById() {
        val dataTvShow = MutableLiveData<TvShow>()
        dataTvShow.value = tvShow
        `when`(local.getDetailTv(tvShow.id)).thenReturn(dataTvShow)
        val data = LiveDataTestUtil.getValue(allRepository.getDetailTvShow(tvShow.id))
        verify(local).getDetailTv(tvShow.id)
        assertNotNull(data)
        assertEquals(tvShow.id, data.id)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        allRepository.getListFavoriteMovie()
        val movieEntities =
            DataResource.success(PagedListUtil.mockPagedList(DataMovie.generateDataMovie()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities.data)
        assertEquals(listMovie.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTv() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(local.getFavoriteTv()).thenReturn(dataSourceFactory)
        allRepository.getListFavoriteTvShow()
        val tvEntities =
            DataResource.success(PagedListUtil.mockPagedList(DataMovie.generateDataTvShow()))
        verify(local).getFavoriteTv()
        assertNotNull(tvEntities.data)
        assertEquals(listTv.size.toLong(), tvEntities.data?.size?.toLong())
    }
}