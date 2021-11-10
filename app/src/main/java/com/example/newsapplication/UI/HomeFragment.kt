package com.example.newsapplication.UI

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.*
import com.example.newsapplication.Interface.NewsApi
import com.example.newsapplication.Model.Model
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {

    private val country : String = "in"
//    private  lateinit var recyclerAdapter: RecyclerAdapter
//    var modelArrayList = ArrayList<Model>()

    private var layoutManager :RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    val TAG = "homeFragment"


    companion object{
        const val API_KEY = "1a7737621cbf49309d60ff95242a2ea4"
        const val BASE_URL: String = "https://newsapi.org/v2/"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(context)
        var recyclerview : RecyclerView = requireView().findViewById(R.id.recyclerViewHome)
        recyclerview.layoutManager = layoutManager

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(NewsApi::class.java)
        val call = service.getHeadlines(country, API_KEY)

        call.enqueue(object : Callback<MainNews>{
            override fun onResponse(call: Call<MainNews>, response: Response<MainNews>) {
                if (response.isSuccessful){
//                    var data = modelArrayList.addAll(response.body()!!.articles)
//                    Log.d(TAG,"$data")
//                    recyclerAdapter = RecyclerAdapter(requireActivity(), modelArrayList)
//                    recyclerAdapter.notifyDataSetChanged()
                    adapter = RecyclerAdapter(requireActivity(),response.body()!!.articles)
                    recyclerview.adapter = adapter

                }
            }

            override fun onFailure(call: Call<MainNews>, t: Throwable) {
                Toast.makeText(context , "task failed", Toast.LENGTH_LONG).show()
            }

        })
    }


}