package com.solar.file.connectapi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  Created by AMBE on 6/4/2019 at 13:57 PM.
 */

object ApiUtils {
    //web api base url
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun createApiService(): ApiService {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}