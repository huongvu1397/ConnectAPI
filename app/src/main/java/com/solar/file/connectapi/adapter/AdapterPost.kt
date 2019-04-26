package com.solar.file.connectapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solar.file.connectapi.R
import com.solar.file.connectapi.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class AdapterPost(private val context: Context, private val postList: ArrayList<Post>) :
    RecyclerView.Adapter<AdapterPost.PostHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, p0, false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(p0: PostHolder, p1: Int) {
        val postItem = postList[p1]
        p0.itemView.postUserId.text = postItem.userId.toString()
        p0.itemView.postId.text = postItem.id.toString()
        p0.itemView.postTitle.text = postItem.title
        p0.itemView.postBody.text = postItem.body
    }

    inner class PostHolder(v: View) : RecyclerView.ViewHolder(v) {
        init {
        }
    }
}