package com.visual.flickerdemo

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

    @GET("rest/")
    fun getImagesByPage(
        @Query("page") page: Int,
        @Query("format") format: String = "json",
        @Query("method") method: String = "flickr.photos.getRecent",
        @Query("per_page") per_page: Int = 20,
        @Query("nojsoncallback") callback: Int = 1,
        @Query("api_key") apiKey: String = "626aa4f12aa5ed78ba8ac28d88b2963e"
    ): Single<RestResponse>
}