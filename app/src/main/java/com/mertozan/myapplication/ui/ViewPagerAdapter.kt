package com.mertozan.myapplication.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mertozan.myapplication.ui.drivers.DriversFragment
import com.mertozan.myapplication.ui.teams.TeamFragment

class ViewPagerAdapter(fragmentManager : FragmentManager,lifecycle: Lifecycle)
    :FragmentStateAdapter(fragmentManager,lifecycle){

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when(position) {

        0->DriversFragment()
        1->TeamFragment()
        else->DriversFragment()

    }

}