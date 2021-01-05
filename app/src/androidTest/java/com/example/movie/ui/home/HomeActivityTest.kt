package com.example.movie.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.movie.R
import com.example.movie.utils.DataMovie
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val movies = DataMovie.generateDataMovie()

    private val tvShow = DataMovie.generateDataTvShow()

    private val delay = 2000L

    @Before
    fun setUp() {

        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovie() {

        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))

    }

    @Test
    fun loadDetailMovie() {

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        Thread.sleep(delay)

        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.text_title)).check(matches(withText(movies[0].title)))

        onView(withId(R.id.text_subtitle)).check(matches(withText(movies[0].subTitle)))

        onView(withId(R.id.text_genre)).check(matches(withText(movies[0].genre)))

        onView(withId(R.id.text_date)).check(matches(withText(movies[0].dateRelease)))

        onView(withId(R.id.text_cast)).check(matches(withText(movies[0].actrees)))

        onView(withId(R.id.text_overview)).check(matches(withText(movies[0].overview)))

        onView(withId(R.id.scroll_view)).perform(swipeUp())

        onView(withId(R.id.btn_share)).perform(click())
    }

    @Test
    fun loadTvShows() {

        onView(withText("Tv Show")).perform(click())

        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShow.size))

    }

    @Test
    fun loadDetailTvShow() {

        onView(withText("Tv Show")).perform(click())

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        Thread.sleep(delay)

        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.text_title)).check(matches(withText(tvShow[0].title)))

        onView(withId(R.id.text_subtitle)).check(matches(withText(tvShow[0].subTitle)))

        onView(withId(R.id.text_genre)).check(matches(withText(tvShow[0].genre)))

        onView(withId(R.id.text_date)).check(matches(withText(tvShow[0].dateRelease)))

        onView(withId(R.id.text_cast)).check(matches(withText(tvShow[0].actrees)))

        onView(withId(R.id.text_overview)).check(matches(withText(tvShow[0].overview)))

        onView(withId(R.id.scroll_view)).perform(swipeUp())

        onView(withId(R.id.btn_share)).perform(click())
    }
}