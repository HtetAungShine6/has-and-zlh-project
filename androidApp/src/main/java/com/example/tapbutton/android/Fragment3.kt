package com.example.tapbutton.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_3.*


class Fragment3 : Fragment(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_3, container, false)
        val btn3: Button = view.findViewById(R.id.button3)
        btn3.setOnClickListener(this)
        return view
    }

    companion object {
        fun newInstance(): Fragment3 {
            return Fragment3()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button3 -> {
                textView3.setText(editText3.getText())
            }
            else -> {
            }
        }
    }
}