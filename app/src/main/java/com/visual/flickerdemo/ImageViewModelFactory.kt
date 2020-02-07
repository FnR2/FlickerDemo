package com.visual.flickerdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ImageViewModelFactory(
    private val paginationDataSourceFactory: PaginationDataSourceFactory
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageListViewModel::class.java)) {
            return ImageListViewModel(paginationDataSourceFactory) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}