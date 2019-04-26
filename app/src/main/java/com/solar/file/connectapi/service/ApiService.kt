package com.solar.file.connectapi.service



import com.solar.file.connectapi.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *  Created by AMBE on 6/4/2019 at 14:03 PM.
 */
interface ApiService {

    @GET("posts")
    fun getPost(): Call<ArrayList<Post>>

    @GET("posts/{id}")
    fun getPostWithId(@Path("id") id : Int) : Call<Post>

//    @GET("comments")
//    fun getComment(): Call<ArrayList<Post>>
//
//    @GET("albums")
//    fun getAlbum(): Call<ArrayList<Post>>
//
//    @GET("photos")
//    fun getPhoto(): Call<ArrayList<Post>>
//
//    @GET("todos")
//    fun getTodo(): Call<ArrayList<Post>>
//
//    @GET("users")
//    fun getUser(): Call<ArrayList<Post>>

}