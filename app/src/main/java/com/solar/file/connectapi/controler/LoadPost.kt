package com.solar.file.connectapi.controler

import android.os.AsyncTask
import com.solar.file.connectapi.model.Post
import com.solar.file.connectapi.service.ApiService
import com.solar.file.connectapi.service.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadPost() : AsyncTask<Unit, Unit, Unit>() {
    private var listener: OnLoadDataListener? = null
    private var data = ArrayList<Post>()
    private lateinit var apiService: ApiService
    fun setOnLoadDataListener(listener: OnLoadDataListener) {
        this.listener = listener
    }

    override fun onPreExecute() {
        super.onPreExecute()
        listener?.onStart()
    }

    override fun doInBackground(vararg params: Unit?) {
        apiService = ApiUtils.createApiService()
        // get all data in /posts
        getAllPost()
        // get post with id = 2
        getAllPostWithId(2)
    }


    interface OnLoadDataListener {
        fun onStart()

        fun onError(error: String?)

        fun onComplete(data: ArrayList<Post>)
    }


    private fun getAllPost() {
        apiService.getPost().enqueue(object : Callback<ArrayList<Post>?> {
            override fun onFailure(call: Call<ArrayList<Post>?>, t: Throwable) {
                listener?.onError(t.message)
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ArrayList<Post>?>, response: Response<ArrayList<Post>?>) {
                if (response.isSuccessful) {
                    for (item in response.body()!!) {
                        data.add(item)
                    }
                    listener?.onComplete(data)
                } else {
                    listener?.onError(response.errorBody().toString())
                }
            }

        })
    }

    private fun getAllPostWithId(id: Int) {
        apiService.getPostWithId(id).enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
               if(response.isSuccessful){
                   response.body()?.let { data.add(it) }
                   listener?.onComplete(data)
               }else{
                   listener?.onError(response.errorBody().toString())
               }
            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                listener?.onError(t.message)
                t.printStackTrace()
            }



        })
    }

}