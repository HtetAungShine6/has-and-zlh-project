package com.example.todo.android.data

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.android.R
import kotlinx.android.synthetic.main.view_holder_paging_list_item.view.*
import android.graphics.Typeface

class ArticleViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.view_holder_paging_list_item, parent, false)
) {
    var article: Article? = null
        private set
    private val nameView = itemView.name

    @SuppressLint("SetTextI18n")
    fun bindTo(item: ArticleListItem?) {
        if (item is ArticleListItem.Separator) {
            nameView.text = "${item.name} Article"
            nameView.setTypeface(null, Typeface.BOLD)
        } else {
            nameView.text = item?.name
            nameView.setTypeface(null, Typeface.NORMAL)
        }
        article = (item as? ArticleListItem.Item)?.article
        nameView.text = item?.name
    }
}