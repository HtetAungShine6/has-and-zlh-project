package com.example.todo.android.data

sealed class ArticleListItem(val name: String) {
    data class Item(val article: Article) :ArticleListItem(article.name)
    data class Separator(private val letter: Char) :ArticleListItem(letter.toUpperCase().toString())
}