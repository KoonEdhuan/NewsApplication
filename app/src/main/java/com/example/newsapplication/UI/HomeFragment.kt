package com.example.newsapplication.UI

import android.os.Bundle
import android.provider.DocumentsContract
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.Interface.NewsApi
import com.example.newsapplication.MainActivity
import com.example.newsapplication.Model.Model
import com.example.newsapplication.R
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    companion object{
        const val API_KEY = "1a7737621cbf49309d60ff95242a2ea4"
        const val BASE_URL: String = "https://newsapi.org/v2/"
    }

    private lateinit var layoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


//        val apiInterface = NewsApi.create().getHeadlines()
//
//        apiInterface.enqueue(object : Callback<List<Model>>{
//            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
//
//                if (response?.body() != null){
//
//                }
//            }
//
//            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(NewsApi::class.java)
        val call = service.getHeadlines()

        call.enqueue(object : Callback<Model>{
            override fun onResponse(call: Call<Model>, response: Response<Model>) {

            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}