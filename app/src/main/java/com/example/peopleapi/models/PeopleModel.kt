package com.example.android4hw1.models

import com.google.gson.annotations.SerializedName

data class PeopleModel(

    @SerializedName("id")
    val id: String ,

    @SerializedName("name")
    val name: String ,

    @SerializedName("gender")
    val gender: String ,

    @SerializedName("age")
    val age: String ,

    @SerializedName("eye_color")
    val eyeColor: String ,

    @SerializedName("hair_color")
    val hairColor: String ,


)

