package com.example.todo.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.todo.android.data.Article
import com.example.todo.android.data.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.drop

private const val ITEMS_PER_PAGE = 50

class ArticleViewModel (repository: ArticleRepository) : ViewModel() {
    val items: Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = {repository.articlePagingSource()}
    )
        .flow
        .cachedIn(viewModelScope)
}