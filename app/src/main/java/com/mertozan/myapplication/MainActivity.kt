package com.mertozan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mertozan.myapplication.common.Constants.DRIVERS
import com.mertozan.myapplication.common.Constants.TEAMS
import com.mertozan.myapplication.databinding.ActivityMainBinding
import com.mertozan.myapplication.ui.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayoutList = arrayListOf(DRIVERS, TEAMS)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabLayoutList[position]
        }.attach()

    }
}