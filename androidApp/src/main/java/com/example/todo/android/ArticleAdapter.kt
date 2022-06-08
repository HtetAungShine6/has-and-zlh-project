//package com.example.todo.android
//
//import android.os.Build
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.annotation.RequiresApi
//import androidx.paging.PagingDataAdapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.example.todo.android.data.Article
//import com.example.todo.android.data.createdText
//import com.example.todo.android.databinding.ViewHolderPagingListItemBinding
//
//class ArticleAdapter : PagingDataAdapter<Article, ArticleViewHolder>(ARTICLE_DIFF_CALLBACK) {
//
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
//        val tile = getItem(position)
//        if (tile != null) {
//            holder.bind(tile)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
//        ArticleViewHolder(
//            ViewHolderPagingListItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//
//
//    companion object {
//        private val ARTICLE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
//            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
//                oldItem.id == newItem.id
//
//            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
//                oldItem == newItem
//        }
//    }
//}
//
//
//class ArticleViewHolder(
//    private val binding: ViewHolderPagingListItemBinding
//): RecyclerView.ViewHolder(binding.root) {
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun bind(article: Article) {
//        binding.apply {
//            binding.title.text = article.title
//            binding.description.text = article.description
//            binding.created.text = article.createdText
//        }
//    }
//}
