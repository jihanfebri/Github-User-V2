package com.example.githubuser.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuser.data.response.ItemsItem
import com.example.githubuser.databinding.ItemUserBinding
import com.example.githubuser.ui.detail.DetailActivity

class UserAdapter : ListAdapter<ItemsItem, UserAdapter.MyUserHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyUserHolder(binding)
    }

    override fun onBindViewHolder(holder: MyUserHolder, position: Int) {
        val review = getItem(position)
        holder.bind(review)

    }

    class MyUserHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(user: ItemsItem) {
            binding.nameItemUser.text = "${user.login}\n"
            Glide.with(binding.root.context).load(user.avatarUrl) // URL Gambar
                .into(binding.imgItemUser)

            itemView.setOnClickListener {

                val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                intentDetail.putExtra("user_login", user.login)
                intentDetail.putExtra("user_id", user.id)
                intentDetail.putExtra("user_avatar", user.avatarUrl)
                itemView.context.startActivity(intentDetail)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemsItem>() {
            override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}