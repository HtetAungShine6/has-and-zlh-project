package com.example.todo.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todo.android.databinding.Fragment5Binding
import com.example.todo.android.network.NetworkViewModel

class Fragment5 : Fragment() {

    private lateinit var binding: Fragment5Binding
    private val networkViewModel by viewModels<NetworkViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.networkViewModel = networkViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

}