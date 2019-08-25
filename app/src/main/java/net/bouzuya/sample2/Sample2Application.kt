package net.bouzuya.sample2

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Sample2Application : Application() {
    // public for testing
    var homeViewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            HomeViewModel() as T
    }
    var inputViewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            InputViewModel() as T
    }

    fun providesHomeViewModelFactory(): ViewModelProvider.Factory = homeViewModelFactory
    fun providesInputViewModelFactory(): ViewModelProvider.Factory = inputViewModelFactory
}
