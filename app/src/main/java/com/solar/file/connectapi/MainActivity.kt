package com.solar.file.connectapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.solar.file.connectapi.adapter.AdapterPost
import com.solar.file.connectapi.controler.LoadPost
import com.solar.file.connectapi.model.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var listSticker: ArrayList<Post>
    private lateinit var postAdapter: AdapterPost
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadPost()
    }

    private fun loadPost() {
        var task = LoadPost()
        listSticker = arrayListOf()
        task.setOnLoadDataListener(object : LoadPost.OnLoadDataListener {
            override fun onStart() {
            }
            override fun onError(error: String?) {
                Toast.makeText(this@MainActivity, error, Toast.LENGTH_LONG).show()
            }
            override fun onComplete(data: ArrayList<Post>) {
                listSticker.addAll(data)
                postAdapter = AdapterPost(this@MainActivity, listSticker)
                rcl_data.adapter = postAdapter
                rcl_data.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)
            }
        })
        task.execute()
    }
}
