package com.example.recycleview_retrofit.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview_retrofit.ui.viewModel.PostViewModel
import com.example.recycleview_retrofit.databinding.ActivityMainBinding
import com.example.recycleview_retrofit.ui.adapter.PostAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPost.layoutManager = LinearLayoutManager(this)
        viewModel.posts.observe(this, {
            posts -> binding.rvPost.adapter = PostAdapter(posts)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this,"Errormessage",Toast.LENGTH_LONG).show()
        })
        viewModel.fetchPost()
    }
}