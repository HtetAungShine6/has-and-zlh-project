//package com.example.todo.android
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.paging.*
//import com.example.todo.android.data.Article
//import com.example.todo.android.data.ArticleRepository
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.drop
//import kotlinx.coroutines.flow.toList
//
//private const val ITEMS_PER_PAGE = 50
//
//class ArticleViewModel (repository: ArticleRepository) : ViewModel() {
//    val items: LiveData<PagingData<Article>> = Pager(
//        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
//        pagingSourceFactory = {repository.articlePagingSource()}
//    )
//        .liveData
//        .cachedIn(viewModelScope)
//
//}
