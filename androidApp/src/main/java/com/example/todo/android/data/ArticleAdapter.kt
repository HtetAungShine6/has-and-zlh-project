package com.example.todo.android.data

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

class ArticleAdapter: PagingDataAdapter<ArticleListItem, ArticleViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(parent)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ArticleListItem>() {
            override fun areItemsTheSame(
                oldItem: ArticleListItem,
                newItem: ArticleListItem
            ): Boolean {
                return if (oldItem is ArticleListItem.Item && newItem is ArticleListItem.Item) {
                    oldItem.article.id == newItem.article.id
                } else if (oldItem is ArticleListItem.Separator && newItem is ArticleListItem.Separator) {
                    oldItem.name == newItem.name
                } else {
                    oldItem == newItem
                }
            }

            override fun areContentsTheSame(
                oldItem: ArticleListItem,
                newItem: ArticleListItem
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}