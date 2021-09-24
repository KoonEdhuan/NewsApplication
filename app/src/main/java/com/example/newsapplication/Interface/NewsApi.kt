package com.example.newsapplication.Interface

import android.provider.ContactsContract
import com.example.newsapplication.Model.Model
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {

    companion object{
        const val API_KEY = "1a7737621cbf49309d60ff95242a2ea4"
        const val BASE_URL: String = "https://newsapi.org/v2/"
    }

//    @get: GET("top-headlines/sources?apiKey=1a7737621cbf49309d60ff95242a2ea4")
//      val sources: Call<Model>

    @get: GET("top-headlines?country-in")
    val data : Call<Model>

    @get: GET("category")
    val cData: Call<Model>

}