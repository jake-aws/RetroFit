package com.example.myretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://dummyjson.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ProductInterfaceAPI::class.java)

        val retrofitData = retrofitBuilder.getProducts()

        retrofitData.enqueue(object : Callback<List<Products>?> {
            override fun onResponse(
                call: Call<List<Products>?>,
                response: Response<List<Products>?>
            ) {
                val responseBody = response.body()!!
                for(data in responseBody){
                    Log.d("MainActivity", "${data.brand}")
                }
            }

            override fun onFailure(call: Call<List<Products>?>, t: Throwable) {
                Log.d("MainActivity", "Failure : ${t.message}")
            }
        })
    }


}