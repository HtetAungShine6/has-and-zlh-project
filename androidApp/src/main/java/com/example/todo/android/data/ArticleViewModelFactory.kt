package com.example.todo.android.data

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ArticleViewModelFactory(
    private val app: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            val articleDao = ArticleDb.get(app).articleDao()
            @Suppress("UNCHECKED_CAST")
            return ArticleViewModel(articleDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}