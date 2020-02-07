package com.visual.flickerdemo

import android.util.Log
import io.reactivex.Single
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val imageService: ImageService
) : Repository {
    override fun getImages(imageRequest: ImageRequest): Single<List<ImageItem>> {
        return imageService.getImagesByPage().map {

            it

        }.onErrorReturn {
            emptyList()
        }
    }
}