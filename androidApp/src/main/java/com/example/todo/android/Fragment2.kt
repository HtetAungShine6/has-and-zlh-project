package com.example.todo.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.codelabs.paging.Injection
import com.example.todo.android.databinding.Fragment2Binding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding
    private val viewModel by viewModels<SharedViewModel>(ownerProducer = {requireActivity()})

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

        val pagingViewModel by viewModels<ArticleViewModel>(
            factoryProducer = { Injection.provideViewModelFactory(owner = this) }
        )
        val items = pagingViewModel.items
        val articleAdapter = ArticleAdapter()

        binding.bindAdapter(articleAdapter)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                items.collectLatest {
                    articleAdapter.submitData(it)
                }
            }
        }
    }
}
private fun Fragment2Binding.bindAdapter(articleAdapter: ArticleAdapter) {
    pagingList.adapter = articleAdapter
    pagingList.layoutManager = LinearLayoutManager(pagingList.context)
    val decoration = DividerItemDecoration(pagingList.context, DividerItemDecoration.VERTICAL)
    pagingList.addItemDecoration(decoration)
}