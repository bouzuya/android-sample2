package net.bouzuya.sample2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val name = "Home"

    private val _goToInputEvent = MutableLiveData<Unit>()
    val goToInputEvent: LiveData<Unit> = _goToInputEvent
    fun goToInput() {
        _goToInputEvent.value = Unit
    }
}
