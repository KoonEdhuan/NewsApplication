package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapplication.Interface.NewsApi
import com.example.newsapplication.Model.Model
import com.example.newsapplication.UI.*
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout : TabLayout = findViewById(R.id.tablayout)
        val vp2 : ViewPager2 = findViewById(R.id.viewPager)

        val adapter = PagerAdapter(supportFragmentManager, lifecycle)
        vp2.adapter = adapter

        adapter.addFragment(HomeFragment(), "home")
        adapter.addFragment(IndiaFragment(), "india")
        adapter.addFragment(SportsFragment(), "sports")
        adapter.addFragment(TechnologyFragment(), "technology")
        adapter.addFragment(InternationalFragment(), "international")

        TabLayoutMediator(tabLayout, vp2){tablayout, position ->
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