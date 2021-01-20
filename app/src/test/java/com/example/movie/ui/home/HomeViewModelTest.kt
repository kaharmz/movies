package com.example.movie.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.movie.data.source.AllRepository
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.ui.vo.DataResource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var allRepository: AllRepository

    @Mock
    private lateinit var observerMovie: Observer<DataResource<PagedList<Movie>>>

    @Mock
    private lateinit var observerTv: Observer<DataResource<PagedList<TvShow>>>

    @Mock
    private lateinit var moviePagedList: PagedList<Movie>

    @Mock
    private lateinit var tvPagedList: PagedList<TvShow>

    @Before
    fun setUp() {
        viewModel = HomeViewModel((allRepository))
    }

    @Test
    fun getAllMovies() {
        val dataMovie = DataResource.success(moviePagedList)
        `when`(dataMovie.data?.size).thenReturn(6)
        val movies = MutableLiveData<DataResource<PagedList<Movie>>>()
        movies.value = dataMovie
        `when`(allRepository.getAllMovie()).thenReturn(movies)
        val movieEntities = viewModel.getListMovie().value?.data
        verify(allRepository).getAllMovie()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(6, movieEntities?.size)
        viewModel.getListMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dataMovie)
    }

    @Test
    fun getAllTvShows() {
        val dataTv = DataResource.success(tvPagedList)
        `when`(dataTv.data?.size).thenReturn(6)
        val tvShow = MutableLiveData<DataResource<PagedList<TvShow>>>()
        tvShow.value = dataTv
        `when`(allRepository.getAllTvShow()).thenReturn(tvShow)
        val tvEntities = viewModel.getListTvShow().value?.data
        verify(allRepository).getAllTvShow()
        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(6, tvEntities?.size)
        viewModel.getListTvShow().observeForever(observerTv)
        verify(observerTv).onChanged(dataTv)
    }
}