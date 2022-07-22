package com.example.peopleapi.data.apiservices

import com.example.peopleapi.models.DetailPeopleModel
import com.example.peopleapi.models.PeopleModel
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