package com.example.todo.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _message = MutableLiveData<List<String>>()

    val messages: LiveData<List<String>> = _message

    fun sendMessage(text: String) {
        val newList = _message.value.orEmpty().toMutableList()
        newList.add(text)
        _message.value = newList
    }

}