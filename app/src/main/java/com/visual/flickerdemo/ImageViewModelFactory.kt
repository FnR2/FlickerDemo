package com.visual.flickerdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ImageViewModelFactory(
    private val imageRepository: ImageRepository,
    private val imageMapper: ImageMapper
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageListViewModel::class.java)) {
            return ImageListViewModel(imageRepository,imageMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}