package com.example.tapbutton.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.tapbutton.Greeting
import android.widget.TextView

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    var btn12 = 0
    var btn2 = 0
    var btn3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.displayTextView)
        val tv2 : TextView = findViewById(R.id.textView2)
        val et : EditText = findViewById(R.id.editText)

        val tap1 = findViewById<Button>(R.id.button1)
        tap1.setOnClickListener {
            btn12++
            tv.setText("Tap1")
        }
        val tap2 = findViewById<Button>(R.id.button2)
        tap2.setOnClickListener {
            btn2++
            tv.setText("Tap2")
        }
        val tap3 = findViewById<Button>(R.id.button3)
        tap3.setOnClickListener {
            btn3++
            tv.setText("Tap3")
        }

        val tap4 = findViewById<Button>(R.id.button4)
        tap4.setOnClickListener {
            tv2.setText(et.getText())
        }
    }
}

