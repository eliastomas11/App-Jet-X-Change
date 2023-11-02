package com.example.jetxchange.data.model.tagresponse

import com.google.gson.annotations.SerializedName

data class TagResponseItem(
    @SerializedName("coin_counter") val coinCounter: Int,
    val coins: List<String>,
    val description: String,
    @SerializedName("ico_counter") val icoCounter: Int,
    val icos: List<String>,
    val id: String,
    val name: String,
    val type: String,
)