package com.example.android4hw1.data.remote.apiservices

import com.example.android4hw1.models.DetailPeopleModel
import com.example.android4hw1.models.PeopleModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleApiService {

    @GET("people")
    suspend fun fetchPeople(): List<PeopleModel>

    @GET("people/{id}")
    suspend fun fetchPeopleId(
        @Path("id") id: String
    ): DetailPeopleModel
}