package com.januscole.kotlinscratchpad

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.januscole.kotlinscratchpad.ui.MainActivity
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class SearchFragmentTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun app_uses_the_correct_AppContext() {
        Assert.assertEquals("com.januscole.kotlinscratchpad", appContext.packageName)
    }

    @Test
    fun search_button_is_visible() {
        Espresso.onView(withId(R.id.searchButton))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun search_button_text() {
        Espresso.onView(withId(R.id.searchButton))
            .check(ViewAssertions.matches(withText("Search")))
    }

    @Test
    fun search_button_changes_text() {
        Espresso.onView(withId(R.id.searchButton))
            .perform(ViewActions.click())
        Espresso.onView(withId(R.id.searchButton))
            .check(ViewAssertions.matches(withText("Searching…")))
    }
}