package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tablayout : TabLayout = findViewById(R.id.tablayout)
        val vp2 : ViewPager2 = findViewById(R.id.viewPager)

        val adapter = PagerAdapter(supportFragmentManager, lifecycle)
        vp2.adapter = adapter

        adapter.addFragment(HomeFragment(), "home")
        adapter.addFragment(IndiaFragment(), "india")
        adapter.addFragment(SportsFragment(), "sports")
        adapter.addFragment(TechnologyFragment(), "technology")
        adapter.addFragment(InternationalFragment(), "international")

        TabLayoutMediator(tablayout, vp2){tablayout, position ->
            when(position){
                0 ->{
                    tablayout.text = "home"
                }
                1 ->{
                    tablayout.text = "india"
                }
                2 ->{
                    tablayout.text = "sports"
                }
                3 ->{
                    tablayout.text = "technology"
                }
                4 ->{
                    tablayout.text = "international"
                }
            }
        }.attach()




    }
}