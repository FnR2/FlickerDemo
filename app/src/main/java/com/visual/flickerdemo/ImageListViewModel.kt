package com.visual.flickerdemo

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import io.reactivex.Observable
import javax.inject.Inject


class ImageListViewModel @Inject constructor(
    private val paginationDataSourceFactory: PaginationDataSourceFactory
) : ViewModel() {

    val imageList: Observable<PagedList<ImageItemModel>> =
        RxPagedListBuilder(paginationDataSourceFactory, PAGE_SIZE)
            .buildObservable()
}


