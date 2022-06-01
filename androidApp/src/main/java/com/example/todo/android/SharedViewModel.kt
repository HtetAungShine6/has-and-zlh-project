package com.example.todo.android

import android.telephony.PhoneNumberUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    //To observe Input message for recycler view
    private val _message = MutableLiveData<List<String>>()

    val messages: LiveData<List<String>> = _message

    fun sendMessage(text: String) {
        val newList = _message.value.orEmpty().toMutableList()
        newList.add(text)
        _message.value = newList
    }

    fun removeMessage(text: String) {
        val newList = _message.value.orEmpty().toMutableList()
        newList.remove(text)
        _message.value = newList
    }

    //To observe Form name
    private val _formName = MutableLiveData<String>()
    val formName: LiveData<String> = _formName

    //To observe Form phone
    private val _formPhone = MutableLiveData<String>()
    val formPhone: LiveData<String> = _formPhone

    //To observe Form city spinner
    private val _formCity = MutableLiveData<String>()
    val formCity: LiveData<String> = _formCity

    fun sendFormName(name: String, phone: String, city: String) {
        _formName.value = name
        _formPhone.value = PhoneNumberUtils.formatNumber(phone, "US")
        _formCity.value = city
    }

}