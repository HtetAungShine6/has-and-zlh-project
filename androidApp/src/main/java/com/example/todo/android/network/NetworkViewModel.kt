package com.example.todo.android.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    init {
        getDataProperties()
    }

    private fun getDataProperties() {

        MarsApi.retrofitService.getProperties().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }
        })

        _response.value = "Get data here!"
    }
}