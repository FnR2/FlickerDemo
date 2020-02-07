package com.visual.flickerdemo

import io.reactivex.Observable
import io.reactivex.Single

interface Repository {
    fun getImages(imageRequest: ImageRequest):Single<List<ImageItem>>
}