package net.bouzuya.sample2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputViewModel : ViewModel() {
    val name = "Input"

    val inputText = MutableLiveData<String>()

    fun ok() {
        TODO()
    }
}
