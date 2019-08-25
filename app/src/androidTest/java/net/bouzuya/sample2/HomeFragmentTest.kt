package net.bouzuya.sample2

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onIdle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import net.bouzuya.sample2.HomeFragmentDirections.Companion.actionHomeToInput
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class HomeFragmentTest {
    private lateinit var viewModel: HomeViewModel
    private lateinit var goToInputEvent: MutableLiveData<Unit>

    @Before
    fun setUp() {
        viewModel = mock(HomeViewModel::class.java)
        goToInputEvent = MutableLiveData()
        `when`(viewModel.goToInputEvent).thenReturn(goToInputEvent) // observe it

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
        onView(withId(R.id.home_go_to_input_button)).check(matches(isDisplayed()))
    }

    @Test
    fun clickGoToInputButton() {
        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_go_to_input_button)).perform(click())

        verify(viewModel).goToInput()
    }

    @Test
    fun observeGoToInputEvent() {
        val navController = mock(NavController::class.java)
        launchFragmentInContainer<HomeFragment>().onFragment { fragment ->
            Navigation.setViewNavController(fragment.view!!, navController)
        }

        goToInputEvent.postValue(Unit) // fire event in main thread
        onIdle() // wait event handling

        verify(navController).navigate(actionHomeToInput())
    }
}
