# ConnectAPI
Lấy dữ liệu JSON trên một server

[DB](https://jsonplaceholder.typicode.com/posts)

Thư viện cần thêm : 
```
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.12.1'
    implementation 'com.google.code.gson:gson:2.8.5'
```

Ở đây mình dùng một Asysntask để load dữ liệu 
```kotlin
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
```


