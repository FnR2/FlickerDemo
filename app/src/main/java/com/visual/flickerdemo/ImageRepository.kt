package com.visual.flickerdemo

import io.reactivex.Single
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val imageService: ImageService
) {
    private var page: Int = 0
    fun getImages(): Single<RestResponse> {
        page++
        return imageService.getImagesByPage(page)
    }
}