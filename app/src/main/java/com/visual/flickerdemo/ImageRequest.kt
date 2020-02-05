package com.visual.flickerdemo

import com.google.gson.annotations.SerializedName

data class ImageRequest(
    @SerializedName("api_key")
    val apiKey: String,
    @SerializedName("extras")
    val extras: String,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("page")
    val page: Int
) {
}