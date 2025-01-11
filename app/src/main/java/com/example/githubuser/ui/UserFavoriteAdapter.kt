package com.example.githubuser.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuser.data.room.FavUserModel
import com.example.githubuser.databinding.ItemUserBinding
import com.example.githubuser.ui.detail.DetailActivity


class UserFavoriteAdapter(private var userFavorite: List<FavUserModel>) :
    RecyclerView.Adapter<UserFavoriteAdapter.UserFavoriteViewHolder>() {


    /*fun setUserFavorite(userFavorite: List<FavUserModel>) {
        print("set")
        this.userFavorite = userFavorite
    }*/


    class UserFavoriteViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(user: FavUserModel) {
            binding.nameItemUser.text = "${user.userName}\n"


            Glide.with(binding.root.context).load(user.avatarURL) // URL Gambar
                .into(binding.imgItemUser)

            itemView.setOnClickListener {
                val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                intentDetail.putExtra("user_login", user.userName)
                intentDetail.putExtra("user_id", user.userId)
                intentDetail.putExtra("user_avatar", user.avatarURL)
                itemView.context.startActivity(intentDetail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFavoriteViewHolder {
        var inflate = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserFavoriteViewHolder(inflate);
    }

    override fun getItemCount(): Int {
        return userFavorite.size;
    }

    override fun onBindViewHolder(holder: UserFavoriteViewHolder, position: Int) {
        holder.bind(userFavorite[position])
    }


}