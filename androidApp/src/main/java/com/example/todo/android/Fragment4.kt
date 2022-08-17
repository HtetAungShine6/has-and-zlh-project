package com.example.todo.android

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil.setContentView
import com.example.todo.android.databinding.Fragment2Binding
import com.example.todo.android.databinding.Fragment3Binding
import com.example.todo.android.databinding.Fragment4Binding
import com.google.android.material.textfield.TextInputEditText
import com.vicmikhailau.maskededittext.MaskedEditText
import kotlinx.android.synthetic.main.fragment_4.*


class Fragment4 : Fragment() {

    private lateinit var binding: Fragment4Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailFocusListener()
        passwordFocusListener()
        phoneFocusListener()

        emailEditText.addTextChangedListener(buttonListener)
        passwordEditText.addTextChangedListener(buttonListener)
        phoneEditText.addTextChangedListener(buttonListener)

        binding.submiteButton.setOnClickListener() {
            submitForm()
        }
    }



    var buttonListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val email1 = emailEditText.text.toString()
            val password1 = passwordEditText.text.toString()
            val phone1 = phoneEditText.text.toString()
            if(email1.isNotEmpty() && password1.isNotEmpty() && phone1.isNotEmpty()){
                submiteButton.isEnabled = true
            }
            if(email1.isEmpty() || password1.isEmpty() || phone1.isEmpty()){
                submiteButton.isEnabled = false
            }
        }

        override fun afterTextChanged(s: Editable?) { }
    }

    private fun submitForm(){
        binding.emailContainer.helperText = validEmail()
        binding.passwordContainer.helperText = validPassword()
        binding.phoneContainer.helperText = validPhone()

        val validEmail = binding.emailContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
        val validPhone = binding.phoneContainer.helperText == null

        if(validEmail && validPhone && validPassword){
            resetForm()
        }else{
            invalidForm()
        }
    }

    private fun resetForm(){
        var message = "Email: " + binding.emailEditText.text
        message += "\nPassword: " + binding.passwordEditText.text
        message += "\nPhone" + binding.phoneEditText.text

        AlertDialog.Builder(this.requireContext())
            .setTitle("Form Submitted")
            .setMessage(message)
            .setPositiveButton("OK"){
                    view, _->
                binding.emailEditText.text = null
                binding.passwordEditText.text = null
                binding.phoneEditText.text = null

            }
            .show()
    }

    private fun invalidForm(){
        var message = ""
        if(binding.emailContainer.helperText != null){
            message += "\n\nEmail: " + binding.emailContainer.helperText
        }
        if(binding.passwordContainer.helperText != null){
            message += "\n\nPassword: " + binding.passwordContainer.helperText
        }
        if(binding.phoneContainer.helperText != null){
            message += "\n\nPhone: " + binding.phoneContainer.helperText
        }
        AlertDialog.Builder(this.requireContext())
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("OK"){
                    _, _->
                //do nothing
            }
            .show()
    }

    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener{ _, focused ->
            if(!focused){
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.emailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.passwordEditText.text.toString()
        if(passwordText.length < 8){
            return "Minimum 8 character password"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Must Contain 1 upper-case Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())){
            return "Must Contain 1 lower-case Character"
        }
        if(!passwordText.matches(".*[0-9].*".toRegex())){
            return "Must Contain 1 number"
        }
        if(!passwordText.matches(".*[!@#\$%^&+=*()].*".toRegex())){
            return "Must Contain 1 special-case Character"
        }
        return null
    }

    private fun phoneFocusListener(){
        binding.phoneEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.phoneContainer.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String?{
        val phoneText = binding.phoneEditText.text.toString()
        if(phoneText.length != 18){
            return "Must be 12 numbers"
        }
        if(!phoneText.matches(".*[0-9].*".toRegex())){
            return "Must be all digits"
        }
        return null
    }
}