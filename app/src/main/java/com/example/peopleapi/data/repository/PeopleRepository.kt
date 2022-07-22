package com.example.android4hw1.data.repository


import com.example.peopleapi.data.apiservices.PeopleApiService
import com.example.peopleapi.data.repository.base.BaseRepository
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val apiService: PeopleApiService) :

    BaseRepository() {

        fun fetchPeople() = doRequest { apiService.fetchPeople() }

        fun fetchPeopleId(id: String) = doRequestId { apiService.fetchPeopleId(id) }
}