package com.example.movie.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.movie.data.source.AllRepository
import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
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
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var allRepository: AllRepository

    @Mock
    private lateinit var observerFavoriteMovie: Observer<PagedList<Movie>>

    @Mock
    private lateinit var observerFavoriteTv: Observer<PagedList<TvShow>>

    @Mock
    private lateinit var movieFavoritePagedList: PagedList<Movie>

    @Mock
    private lateinit var tvFavoritePagedList: PagedList<TvShow>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(allRepository)
    }

    @Test
    fun getAllFavoriteMovie() {
        val dataMovie = movieFavoritePagedList
        `when`(dataMovie.size).thenReturn(6)
        val movies = MutableLiveData<PagedList<Movie>>()
        movies.value = dataMovie
        `when`(allRepository.getListFavoriteMovie()).thenReturn(movies)
        val movieEntities = viewModel.getListFavoriteMovie().value
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(6, movieEntities?.size)
        viewModel.getListFavoriteMovie().observeForever(observerFavoriteMovie)
        verify(observerFavoriteMovie).onChanged(dataMovie)
    }

    @Test
    fun getAllFavoriteTvShow() {
        val dataTvShows = tvFavoritePagedList
        `when`(dataTvShows.size).thenReturn(6)
        val tvShows = MutableLiveData<PagedList<TvShow>>()
        tvShows.value = dataTvShows
        `when`(allRepository.getListFavoriteTvShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getListFavoriteTv().value
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(6, tvShowEntities?.size)
        viewModel.getListFavoriteTv().observeForever(observerFavoriteTv)
        verify(observerFavoriteTv).onChanged(dataTvShows)
    }
}