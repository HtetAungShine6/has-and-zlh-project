package com.example.todo.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.todo.android.databinding.Fragment1Binding
import kotlinx.android.synthetic.main.fragment_1.view.*

class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
//        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        binding.btnSave.setOnClickListener {
            model.sendMessage(binding.edText.text.toString())
        }



        binding.btnFormSubmit.setOnClickListener{
            model.sendFormName(
                binding.edFormName.text.toString(),
                binding.edFormPhoneNumber.text.toString(),
                binding.spinnerCitySelection.selectedItem.toString()
            )
        }


    }
}