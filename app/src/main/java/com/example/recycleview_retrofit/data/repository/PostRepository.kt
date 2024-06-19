package com.example.recycleview_retrofit.data.repository

import com.example.recycleview_retrofit.data.api.RetrofitClient
import com.example.recycleview_retrofit.data.model.ItemPost
import retrofit2.Response

class PostRepository  {
    fun getPosts() : Response<List<ItemPost>> {
        return RetrofitClient.apiService.getPosts()
    }
}