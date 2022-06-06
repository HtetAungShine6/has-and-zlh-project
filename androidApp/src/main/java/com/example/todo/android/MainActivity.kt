package com.example.todo.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.Greeting
import android.widget.TextView
import com.example.todo.android.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

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
                2 -> {
                    tab.text = "TAB 3"
                }
            }

        }.attach()
    }
    fun switch() {
        binding.viewPager.currentItem = 1
    }
}
