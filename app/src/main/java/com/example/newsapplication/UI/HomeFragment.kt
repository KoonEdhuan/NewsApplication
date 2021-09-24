package com.example.newsapplication.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.Interface.NewsApi
import com.example.newsapplication.MainActivity
import com.example.newsapplication.Model.Model
import com.example.newsapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        var rv: RecyclerView = view.findViewById(R.id.HomeRecyclerView)

        var rf = Retrofit.Builder()
            .baseUrl(NewsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        var API = rf.create(NewsApi::class.java)
        var call = API.data

        call.enqueue(object: Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                var dataList : List<Model>? = response.body() as List<Model>
                var data = arrayOfNulls<String>(dataList!!.size)

                for (i in dataList!!.indices){
                    data[i] = dataList[i].author
                    data[i] = dataList[i].title
                    data[i] = dataList[i].description
                    data[i] = dataList[i].url
                    data[i] = dataList[i].urltoImage
                    data[i] = dataList[i].publishedAt
                }

                var adapter = ArrayAdapter<String>(context, R.layout.recycler_item_layout,data)
                rv.adapter = adapter


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