package com.example.advancedwealthtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Naming : sa_ze_

        val viewPager = findViewById<ViewPager2>(R.id.sa_ze_view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.sa_ze_tab_layout)


        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // გვარი Apkhadze (A - ხმოვანი) -> Horizontal რეჟიმი
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Input"
                1 -> "Analytics"
                else -> "Profile"
            }
        }.attach()
    }
}