package com.example.todo.android

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.Greeting
import android.widget.TextView
import com.example.todo.android.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.custom_dialog.*

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
        showStartAdPopup()

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
                3 -> {
                    tab.text = "TAB 4"
                }
            }

        }.attach()
    }
    fun switch() {
        binding.viewPager.currentItem = 1
    }

    private fun showStartAdPopup() {
        val dialog1 =  Dialog (this,android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog1.setContentView(R.layout.custom_dialog)
        dialog1.closeDialog.setOnClickListener(){
            dialog1.dismiss()
        }
        dialog1.show()
    }

}
