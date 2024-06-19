package com.example.recycleview_retrofit.ui.viewModel

import android.content.ClipData.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycleview_retrofit.data.api.RetrofitClient
import com.example.recycleview_retrofit.data.api.ApiService
import com.example.recycleview_retrofit.data.model.ItemPost
import com.example.recycleview_retrofit.data.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private var postRepository = PostRepository()
    val posts = MutableLiveData<List<ItemPost>>()
    val errorMessage = MutableLiveData<String>()

    fun fetchPost() {
        // 1. Gọi API từ retrofit
        // 2. Update livedata
        viewModelScope.launch {
            val response = postRepository.getPosts()
            if(response.isSuccessful){
                posts.postValue(response.body())
            }
            else{
                errorMessage.postValue("Error: ${response.message()}")
            }
        }
    }
}