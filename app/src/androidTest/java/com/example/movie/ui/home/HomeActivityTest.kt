package com.example.movie.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.movie.R
import com.example.movie.utils.DataMovie
import com.example.movie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataMovie.generateDataMovie()

    private val dummyTvShow = DataMovie.generateDataTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)

        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {

        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovie() {

        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))

    }

    @Test
    fun loadDetailMovie() {

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.text_release)).check(matches(withText(dummyMovie[0].releaseDate)))

        onView(withId(R.id.text_language)).check(matches(withText("en")))

        onView(withId(R.id.text_vote_average)).check(matches(isDisplayed()))

        onView(withId(R.id.text_vote_count)).check(matches(isDisplayed()))

        onView(withId(R.id.text_overview)).check(matches(withText(dummyMovie[0].overview)))

        onView(withId(R.id.scroll_view)).perform(swipeUp())

        onView(withId(R.id.btn_share)).perform(click())
    }

    @Test
    fun loadTvShows() {

        onView(withText("Tv Show")).perform(click())

        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))

    }

    @Test
    fun loadDetailTvShow() {

        onView(withText("Tv Show")).perform(click())

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.text_title)).check(matches(withText(dummyTvShow[0].name)))

        onView(withId(R.id.text_release)).check(matches(withText(dummyTvShow[0].firstAirDate)))

        onView(withId(R.id.text_language)).check(matches(withText(dummyTvShow[0].originalLanguage)))

        onView(withId(R.id.text_vote_average)).check(matches(isDisplayed()))

        onView(withId(R.id.text_vote_count)).check(matches(isDisplayed()))

        onView(withId(R.id.text_overview)).check(matches(withText(dummyTvShow[0].overview)))

        onView(withId(R.id.scroll_view)).perform(swipeUp())

        onView(withId(R.id.btn_share)).perform(click())
    }
}