package com.example.peopleapi.ui.fragments.details

import com.example.android4hw1.data.repository.PeopleRepository
import com.example.peopleapi.base.BaseViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleDetailViewModel @Inject constructor (private val repository : PeopleRepository) :
    BaseViewModel() {

    fun fetchPeopleId(id : String) = repository.fetchPeopleId(id)
}