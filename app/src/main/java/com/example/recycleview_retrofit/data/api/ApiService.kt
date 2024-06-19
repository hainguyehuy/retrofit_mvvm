package com.example.recycleview_retrofit.data.api

import com.example.recycleview_retrofit.data.model.ItemPost
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts() : Response<List<ItemPost>>
}