package com.example.recycleview_retrofit.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {

    companion object RetrofitClient{
        var url = "https://jsonplaceholder.typicode.com"

            val apiService : ApiService = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)

    }
}