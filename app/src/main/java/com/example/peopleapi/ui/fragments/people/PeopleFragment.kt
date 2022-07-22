package com.example.peopleapi.ui.fragments.people

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.peopleapi.ui.adapters.PeopleAdapter
import com.example.peopleapi.Either
import com.example.peopleapi.R
import com.example.peopleapi.base.BaseFragment
import com.example.peopleapi.databinding.FragmentPeopleBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : BaseFragment<PeopleViewModel, FragmentPeopleBinding>(R.layout.fragment_people) {

    override val binding by viewBinding(FragmentPeopleBinding::bind)
    override val viewModel: PeopleViewModel by viewModels()
    private val heroesAdapter = PeopleAdapter(
        this::onItemClick
    )

    override fun initialize() {
       init()
    }

    private fun init() = with(binding.recyclerHeroes) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = heroesAdapter
    }

    override fun setupSubscribes() {
        setupObserv()
    }

    private fun setupObserv() {
        viewModel.fetchPeople().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Anime", it.toString())
                    heroesAdapter.submitList(it.value)
                }
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            PeopleFragmentDirections.actionPeopleFragmentToDetailPeopleFragment(
                position = id
            )
        )
    }
}