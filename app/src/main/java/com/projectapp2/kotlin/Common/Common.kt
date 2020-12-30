package com.projectapp2.kotlin.Common

import com.projectapp2.kotlin.Interface.RetrofitService
import com.projectapp2.kotlin.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://raw.githubusercontent.com/Maximeguenneteau/MyProject/master/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}