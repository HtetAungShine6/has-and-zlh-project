package com.example.todo.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.android.data.ArticleAdapter
import com.example.todo.android.data.ArticleViewHolder
import com.example.todo.android.data.ArticleViewModel
import com.example.todo.android.data.ArticleViewModelFactory
import com.example.todo.android.databinding.Fragment2Binding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding
    private val viewModel by viewModels<SharedViewModel>(ownerProducer = {requireActivity()})
    private val articleViewModel by viewModels<ArticleViewModel> { ArticleViewModelFactory(requireActivity().application) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = ResultTextAdapter{viewModel.removeMessage(it)}
        binding.rvResult.adapter = adapter

        viewModel.messages.observe(viewLifecycleOwner){
            it?.let {
                adapter.setNewData(it)
            }
        }

        val articleAdapter = ArticleAdapter()
        binding.articleList.adapter = articleAdapter

        lifecycleScope.launch {
            articleViewModel.allArticles.collectLatest { articleAdapter.submitData(it) }
        }

        initSwipeToDelete()
    }

    private fun initSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val articleViewHolder = viewHolder as ArticleViewHolder
                return  if (articleViewHolder.article != null) {
                    makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
                } else {
                    makeMovementFlags(0, 0)
                }
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                (viewHolder as ArticleViewHolder).article?.let {
                    articleViewModel.remove(it)
                }
            }
        }).attachToRecyclerView(binding.articleList)
    }
}