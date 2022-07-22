package com.example.android4hw1.data.repository

import androidx.lifecycle.liveData

import com.example.android4hw1.data.remote.apiservices.PeopleApiService
import com.example.peopleapi.Either
import com.example.peopleapi.data.repository.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val apiService: PeopleApiService) :

    BaseRepository() {

        fun fetchPeople() = doRequest { apiService.fetchPeople() }

        fun fetchPeopleId(id: String) = doRequestId { apiService.fetchPeopleId(id) }
}