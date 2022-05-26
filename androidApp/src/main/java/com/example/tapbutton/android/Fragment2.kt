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
import kotlinx.android.synthetic.main.fragment_2.*


class Fragment2 : Fragment(),View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_2, container, false)
        val btn2: Button = view.findViewById(R.id.button2)
        btn2.setOnClickListener(this)
        return view
    }

    companion object {
        fun newInstance(): Fragment2 {
            return Fragment2()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button2 -> {
                textView2.setText(editText2.getText())
            }
            else -> {
            }
        }
    }
}