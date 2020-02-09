package com.visual.flickerdemo

import android.content.Context
import javax.inject.Inject

class ImageMapper @Inject constructor(
    private val context: Context
) {

    fun map(imageItemList: List<ImageItem>): List<ImageItemModel> {

        val result = mutableListOf<ImageItemModel>()

        imageItemList.forEach {

            val imageUrl = generateImageUrl(it, context)
            result.add(ImageItemModel(it.id, imageUrl))

        }

        return result
    }

    private fun generateImageUrl(item: ImageItem, context: Context): String {
        val formatUrl = context.getString(R.string.image_url)
        val server = context.getString(R.string.server_arg)
        val farm = context.getString(R.string.farm_arg)
        val photo = context.getString(R.string.photo_arg)
        val secret = context.getString(R.string.secret_arg)

        return formatUrl.replace("{$server}", item.server.toString())
            .replace("{$farm}", item.farm.toString())
            .replace("{$photo}", item.id)
            .replace("{$secret}", item.secret)
    }
}