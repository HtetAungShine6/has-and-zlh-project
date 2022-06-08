package com.example.newtappage

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}