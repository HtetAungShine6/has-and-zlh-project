package com.example.todo.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    var message = mutableListOf<String>()
    var _message = MutableLiveData<MutableList<String>>()

    fun sendMessage(text: List<String>) {
        message.addAll(text)
        _message.value = message
    }
}