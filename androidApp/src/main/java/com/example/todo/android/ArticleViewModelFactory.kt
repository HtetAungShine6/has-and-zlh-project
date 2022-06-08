//package com.example.todo.android
//
//import androidx.lifecycle.AbstractSavedStateViewModelFactory
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.savedstate.SavedStateRegistryOwner
//import com.example.todo.android.data.ArticleRepository
//
//class ArticleViewModelFactory(
//    owner: SavedStateRegistryOwner,
//    private val repository: ArticleRepository
//) : AbstractSavedStateViewModelFactory(owner, null) {
//
//    override fun <T : ViewModel?> create(
//        key: String,
//        modelClass: Class<T>,
//        handle: SavedStateHandle
//    ): T {
//        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return ArticleViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}