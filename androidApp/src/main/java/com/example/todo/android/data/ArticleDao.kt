package com.example.todo.android.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {

    @Query("SELECT * FROM Cheese ORDER BY name COLLATE NOCASE ASC")
    fun allArticlesByName():PagingSource<Int, Article>

    @Insert
    fun insert(cheeses: List<Article>)

    @Delete
    fun delete(article: Article)
}