package com.visual.flickerdemo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import javax.inject.Inject

class PaginationDataSourceFactory @Inject constructor(
    private val paginationDataSource: PaginationDataSource
) : DataSource.Factory<Int, ImageItemModel>() {

    private val imagesLiveData = MutableLiveData<PaginationDataSource>()

    override fun create(): DataSource<Int, ImageItemModel> {
        imagesLiveData.postValue(paginationDataSource)
        return paginationDataSource
    }
}