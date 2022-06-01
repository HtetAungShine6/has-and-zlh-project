package com.example.todo.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.todo.android.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater, container, false)
//        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)



        model.messages.observe(viewLifecycleOwner){
            it?.let {
                binding.rvResult.adapter = ResultTextAdapter(it.toMutableList())
            }
        }

        model.formName.observe(viewLifecycleOwner) {
            it?.let {
                binding.tvFormResultName.text = it.toString()
            }
        }

        model.formPhone.observe(viewLifecycleOwner) {
            it?.let {
                binding.tvFormResultPhone.text = it.toString()
            }
        }

        model.formCity.observe(viewLifecycleOwner) {
            it?.let {
                binding.tvFormCity.text = it.toString()
            }
        }


    }
}