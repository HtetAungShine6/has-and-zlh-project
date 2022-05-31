package com.example.todo.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.Greeting
import android.widget.TextView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapterVP = ViewPagerAdapter(this)
        viewPager.adapter = adapterVP

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "TAB 1"
                }
                1 -> {
                    tab.text = "TAB 2"
                }
            }

        }.attach()
    }
}
