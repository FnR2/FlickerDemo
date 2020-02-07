package com.visual.flickerdemo

import androidx.paging.ItemKeyedDataSource
import javax.inject.Inject

class PaginationDataSource @Inject constructor(
    private val imageRepository: ImageRepository,
    private val imageMapper: ImageMapper
) : ItemKeyedDataSource<Int, ImageItemModel>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<ImageItemModel>
    ) {
        val items = imageRepository.getImages(ImageRequest("", "", 0, 0))
            .map {
                callback.onResult(imageMapper.map(it), 1, 1)
            }

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<ImageItemModel>) {
        val items = imageRepository.getImages(ImageRequest("", "", 0, 0))
            .map {
                callback.onResult(imageMapper.map(it))
            }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<ImageItemModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: ImageItemModel): Int {
        return item.id
    }


}