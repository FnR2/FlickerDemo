package com.visual.flickerdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ImageListViewModel @Inject constructor(
    private val imageRepository: ImageRepository,
    private val mapper: ImageMapper
) : ViewModel() {

    private var disposable: CompositeDisposable? = null

    private var images: MutableLiveData<List<ImageItemModel>> = MutableLiveData()

    private var totalList = mutableListOf<ImageItemModel>()

    private val errorMessage: MutableLiveData<String> = MutableLiveData()


    init {
        disposable = CompositeDisposable()
        fetchImages()
    }

    fun fetchImages() {

        disposable!!.add(
            imageRepository.getImages().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<RestResponse>() {
                    override fun onSuccess(value: RestResponse) {

                        if (value.stat != "fail") {
                            totalList.addAll(mapper.map(value.photos.photo))
                            images.postValue(totalList)

                        } else {
                            errorMessage.postValue(value.message)
                        }

                    }

                    override fun onError(e: Throwable) {
                        errorMessage.postValue(e.toString())
                    }
                })
        )
    }

    fun getImages(): LiveData<List<ImageItemModel>> {
        return images
    }

    fun getError(): LiveData<String> {
        return errorMessage
    }

}


