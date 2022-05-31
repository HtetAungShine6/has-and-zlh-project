package com.example.todo.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.todo.android.databinding.Fragment2Binding
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.android.synthetic.main.view_holder_todo_list_item.*

class Fragment2 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)



        model.messages.observe(viewLifecycleOwner){
            it?.let {
                rvResult.adapter = ResultTextAdapter(it.toMutableList())
            }
        }

    }
}