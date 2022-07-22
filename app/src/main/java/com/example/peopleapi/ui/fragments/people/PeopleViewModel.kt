package com.example.android4hw1.ui.fragments.heroes

import com.example.android4hw1.data.repository.PeopleRepository
import com.example.peopleapi.base.BaseViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor (private val repository : PeopleRepository) :
    BaseViewModel() {

    fun fetchPeople() = repository.fetchPeople()
}
