package net.bouzuya.sample2

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class InputFragmentTest {
    lateinit var viewModel: InputViewModel

    @Before
    fun setUp() {
        viewModel = mock(InputViewModel::class.java)

        val application =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as Sample2Application
        application.inputViewModelFactory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel as T
        }
    }

    @Test
    fun initialView() {
        launchFragmentInContainer<InputFragment>()

        onView(withId(R.id.input_name_text_view)).check(matches(ViewMatchers.isDisplayed()))
    }
}
