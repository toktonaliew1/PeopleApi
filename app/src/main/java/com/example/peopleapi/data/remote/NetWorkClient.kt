package com.example.peopleapi.data.remote

import com.example.android4hw1.data.remote.apiservices.PeopleApiService
import com.example.peopleapi.data.apiservices.OkHttp
import com.example.peopleapi.data.apiservices.RetrofitClient
import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun providePeopleApiService() = provideRetrofit.create(PeopleApiService::class.java)
}