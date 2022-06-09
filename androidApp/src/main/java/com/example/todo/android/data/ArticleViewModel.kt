package com.example.todo.android.data

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleViewModel(private val dao: ArticleDao) : ViewModel() {

    val allArticles: Flow<PagingData<ArticleListItem>> = Pager(
        config = PagingConfig(
            pageSize = 50,
            enablePlaceholders = true,
            maxSize = 200
        )
    ) {
        dao.allArticlesByName()
    }.flow
        .map {  pagingData ->
            pagingData
                .map { article -> ArticleListItem.Item(article) }
                .insertSeparators { before: ArticleListItem?, after: ArticleListItem? ->
                    if (before == null && after == null) {
                        null
                    } else if (after == null) {
                        null
                    } else if (before == null) {
                        ArticleListItem.Separator(after.name.first())
                    } else if (!before.name.first().equals(after.name.first(), ignoreCase = true)){
                        ArticleListItem.Separator(after.name.first())
                    } else {
                        null
                    }
                }
        }
        .cachedIn(viewModelScope)

    fun remove(article: Article) = ioThread {
        dao.delete(article)
    }
}