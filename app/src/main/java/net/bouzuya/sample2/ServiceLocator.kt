package net.bouzuya.sample2

import android.content.Context
import androidx.lifecycle.ViewModelProvider

object ServiceLocator {
    fun providesHomeViewModelFactory(context: Context): ViewModelProvider.Factory =
        (context.applicationContext as Sample2Application).providesHomeViewModelFactory()
}
