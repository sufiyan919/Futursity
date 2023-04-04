package com.sufiyan.futursity



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.sufiyan.futursity.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val Base_url = "https://futursity.com/course/api/"

lateinit var retrofitB: Api
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        retrofitB = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base_url)
            .build()
            .create(Api::class.java)
        getcourse()
        getcategory()

    }

    private fun getcourse() {

        val retrofitdata = retrofitB.getCourse()

         retrofitdata.enqueue(object : Callback<List<CourseModel>>{
             override fun onResponse(
                 call: Call<List<CourseModel>>,
                 response: Response<List<CourseModel>>
             ) {

                 binding.rvMain.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                 val adApter = CourseAdapter(response.body()?:ArrayList())
                 binding.rvMain.adapter=adApter
             }

             override fun onFailure(call: Call<List<CourseModel>>, t: Throwable) {

             }

         })



    }


    private fun getcategory() {

        val retrofitdata = retrofitB.getCategory()

        retrofitdata.enqueue(object : Callback<List<MainModel>> {
            override fun onResponse(
                call: Call<List<MainModel>>,
                response: Response<List<MainModel>>
            ) {

                binding.rvMain22.layoutManager =
                    GridLayoutManager(this@MainActivity,2)
                val adApter = MainAdapter(response.body() ?: ArrayList())
                binding.rvMain22.adapter = adApter
            }

            override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {

            }

        })


    }






}
