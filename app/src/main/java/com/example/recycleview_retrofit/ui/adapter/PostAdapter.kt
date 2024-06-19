package com.example.recycleview_retrofit.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview_retrofit.R
import com.example.recycleview_retrofit.data.model.ItemPost
import com.example.recycleview_retrofit.databinding.ItempostLayoutBinding


class PostAdapter(private val users: List<ItemPost>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItempostLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    class PostViewHolder(private val binding: ItempostLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemPost: ItemPost) {
            binding.tvId.text = itemPost.id.toString()
            binding.tvTitle.text = itemPost.title
            binding.tvBody.text = itemPost.body
        }
    }
}