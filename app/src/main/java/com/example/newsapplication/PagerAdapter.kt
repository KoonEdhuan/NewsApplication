package com.example.newsapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapplication.UI.*


class PagerAdapter(manager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(manager, lifecycle){

    private val fragmentList : MutableList<Fragment> = ArrayList()
    private val titleList : MutableList<String> = ArrayList()


    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                HomeFragment()
            }
            1 -> {
                IndiaFragment()
            }
            2 -> {
                SportsFragment()
            }
            3 -> {
                TechnologyFragment()
            }
            4 -> {
                InternationalFragment()
            }
            else -> {
                Fragment()
            }
        }
    }


    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

}