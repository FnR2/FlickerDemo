package com.visual.flickerdemo

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ImageService {

    @GET("&api_sig=075a1eeb9e7c32f78ff5ae834679dad2")
    fun getImagesByPage(): Single<List<ImageItem>>
}