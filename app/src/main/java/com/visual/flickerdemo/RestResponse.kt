package com.visual.flickerdemo

data class RestResponse(
    val photos: Photos,
    val stat: String,
    val code: Int?,
    val message: String?
)

data class Photos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: List<ImageItem>
)