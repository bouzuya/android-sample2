package net.bouzuya.sample2

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class HomeFragmentTest {
    lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = mock(HomeViewModel::class.java)

        val application =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as Sample2Application
        application.homeViewModelFactory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel as T
        }
    }

    @Test
    fun initialView() {
        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_name_text_view)).check(matches(isDisplayed()))
    }
}
