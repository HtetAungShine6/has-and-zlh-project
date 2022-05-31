package com.example.todo

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}