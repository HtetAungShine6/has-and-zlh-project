package com.example.todo.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.todo.android.databinding.Fragment1Binding
import com.vicmikhailau.maskededittext.MaskedFormatter
import com.vicmikhailau.maskededittext.MaskedWatcher

class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding
    private val viewModel by viewModels<SharedViewModel>(ownerProducer = {requireActivity()})
    private var formatter: MaskedFormatter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSave.setOnClickListener {
            viewModel.sendMessage(binding.edText.text.toString())
            (requireActivity() as MainActivity).switch()
        }




        binding.btnFormSubmit.setOnClickListener{
            viewModel.sendFormName(
                binding.edFormName.text.toString(),
                binding.edFormPhoneNumber.text.toString(),
                binding.spinnerCitySelection.selectedItem.toString()
            )
            (requireActivity() as MainActivity).switch()
        }
    }
}