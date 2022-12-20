package com.example.myretrofit

import retrofit2.Call
import retrofit2.http.GET

interface ProductInterfaceAPI {

    @GET("products")
    fun getProducts():Call<List<Products>>
}