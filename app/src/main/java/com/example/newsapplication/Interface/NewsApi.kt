package com.example.newsapplication.Interface

import android.provider.ContactsContract
import com.example.newsapplication.Model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    companion object{
        const val API_KEY = "1a7737621cbf49309d60ff95242a2ea4"
        const val BASE_URL: String = "https://newsapi.org/v2/"

//        fun create() : NewsApi{
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//            return retrofit.create(NewsApi::class.java)
//        }
    }

//    @get: GET("top-headlines/sources?apiKey=1a7737621cbf49309d60ff95242a2ea4")
//      val sources: Call<Model>

    @GET("top-headlines?country-in&apiKey="+ API_KEY)
    fun getHeadlines() : Call<Model>

    @GET("")
    fun categoryNews() : Call<Model>

}