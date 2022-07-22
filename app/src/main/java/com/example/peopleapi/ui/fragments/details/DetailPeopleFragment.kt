package com.example.peopleapi.ui.fragments.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4hw1.ui.fragments.details.PeopleDetailViewModel
import com.example.peopleapi.Either
import com.example.peopleapi.R
import com.example.peopleapi.base.BaseFragment
import com.example.peopleapi.databinding.FragmentDetailPeopleBinding
import com.example.peopleapi.databinding.FragmentPeopleBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPeopleFragment :
    BaseFragment<PeopleDetailViewModel, FragmentDetailPeopleBinding>(R.layout.fragment_detail_people) {

    override val binding by viewBinding(FragmentDetailPeopleBinding::bind)
    override val viewModel: PeopleDetailViewModel by viewModels()
    private val args by navArgs<DetailPeopleFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchPeopleId(args.position).observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value.toString())
                }
                is Either.Right -> {
                    Log.e("Anime", it.toString())
                    binding.itemPeopleName.text = it.value.name
                    binding.itemPeopleGender.text = it.value.gender
                    binding.itemPeopleAge.text = it.value.age
                    binding.itemPeopleEyeColor.text = it.value.eyeColor
                    binding.itemPeopleHairColor.text = it.value.hairColor
                }
            }
        }
    }
}
