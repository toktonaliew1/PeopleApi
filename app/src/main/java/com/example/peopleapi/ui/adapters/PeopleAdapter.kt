package com.example.peopleapi.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.peopleapi.models.PeopleModel
import com.example.peopleapi.databinding.ItemPeopleBinding

class PeopleAdapter(private val itemClick: (id: String) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<PeopleModel, PeopleAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPeopleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemPeopleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: PeopleModel) {
            binding.itemPeopleName.text = item.name
            binding.itemPeopleAge.text = item.age
            binding.itemPeopleGender.text = item.gender
            binding.itemPeopleEyeColor.text = item.eyeColor
            binding.itemPeopleHairColor.text = item.hairColor
        }

        init {
            binding.root.setOnClickListener {
                getItem(absoluteAdapterPosition)?.apply {
                    itemClick(id)
                }
            }
        }
    }

    companion object {

        private val diffCallback: DiffUtil.ItemCallback<PeopleModel> =
            object : DiffUtil.ItemCallback<PeopleModel>() {
                override fun areItemsTheSame(
                    oldItem: PeopleModel,
                    newItem: PeopleModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: PeopleModel,
                    newItem: PeopleModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}
