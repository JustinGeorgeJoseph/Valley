package com.justin.valley.ui

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.justin.valley.R
import com.justin.valley.adapters.CoursesAdapter
import com.justin.valley.adapters.HomeAdapter
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeActivityTest {

    @get:Rule
    public var rule= ActivityScenarioRule(HomeActivity::class.java)


    @Test
    fun homeActivity_withNewEpisodes_returnTrue(){
        Thread.sleep(3000)
        onView(ViewMatchers.withId(R.id.recy_home))
            .perform(
                RecyclerViewActions.scrollTo<HomeAdapter.HomeViewHolder>(
                    hasDescendant(withText("New Episodes"))
                )
            )
    }

    @Test
    fun homeActivity_withCategories_returnTrue(){
        Thread.sleep(3000)
        onView(ViewMatchers.withId(R.id.recy_home))
            .perform(
                RecyclerViewActions.scrollTo<HomeAdapter.HomeViewHolder>(
                    hasDescendant(withText("Browse by categories"))
                )
            )
    }

    @Test
    fun homeActivity_withChannels_returnTrue() {
        Thread.sleep(3000)
        onView(ViewMatchers.withId(R.id.recy_home))
            .perform(
                RecyclerViewActions.scrollToPosition<HomeAdapter.HomeViewHolder>(2)
            )
        onView(withText("Mentoring At Work")).check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
    }

    @Test
    fun homeActivity_withChannelContents_returnTrue() {
        Thread.sleep(3000)
        onView(ViewMatchers.withId(R.id.recy_home))
            .perform(
                RecyclerViewActions.scrollToPosition<HomeAdapter.HomeViewHolder>(2)
            )
        onView(withIndex(ViewMatchers.withId(R.id.recy_courses),1))
            .perform(
                RecyclerViewActions.scrollToPosition<CoursesAdapter.CoursesViewHolder>(5)
            )
        onView(withText("Principles of Organizational Health")).check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
    }


    fun withIndex(matcher: Matcher<View?>, index: Int): Matcher<View?> {
        return object : TypeSafeMatcher<View?>() {
            var currentIndex = 0

            override fun describeTo(description: org.hamcrest.Description?) {
                description?.appendText("with index: ");
                description?.appendValue(index);
                matcher.describeTo(description);
            }

            override fun matchesSafely(item: View?): Boolean {
                return matcher.matches(item) && currentIndex++ == index;
            }
        }
    }


}