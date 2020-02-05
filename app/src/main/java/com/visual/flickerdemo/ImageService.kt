package com.visual.flickerdemo

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ImageService {

    @POST
    fun getImagesByPage(@Body imageRequest: ImageRequest)
}