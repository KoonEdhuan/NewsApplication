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

                    var rf = Retrofit.Builder()
                        .baseUrl(NewsApi.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build()

                    var API = rf.create(NewsApi::class.java)
                    var call = API.getHeadlines()

                    call.enqueue(object:Callback<Model>{
                        override fun onResponse(call: Call<Model>, response: Response<Model>) {
                            var dataList : List<Model>? = response.body() as List<Model>
                            var data = arrayOfNulls<String>(dataList!!.size)

                            for (i in dataList!!.indices){
                                data[i] = dataList[i].author
                                data[i] = dataList[i].title
                                data[i] = dataList[i].description
                                data[i] = dataList[i].url
                                data[i] = dataList[i].urlToImage
                                data[i] = dataList[i].publishedAt
                            }

                            var adapter = ArrayAdapter<String>(applicationContext, R.layout.recycler_item_layout, data)


                        }

                        override fun onFailure(call: Call<Model>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                    })
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