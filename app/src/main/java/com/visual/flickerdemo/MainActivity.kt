package com.visual.flickerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @BindView(R.id.rv_images)
    lateinit var rvImages: RecyclerView

    @Inject
    lateinit var imageAdapter: ImageAdapter

    @Inject
    lateinit var imageViewModel: ImageListViewModel

    @Inject
    lateinit var imageViewModelFactory: ImageViewModelFactory

    private var disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        rv_images.adapter = imageAdapter
        imageViewModel =
            ViewModelProviders.of(this, imageViewModelFactory).get(ImageListViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        disposables +=
            imageViewModel.imageList.subscribeBy(
                onNext = {
                    render(it)
                },
                onError = {

                }
            )

    }

    override fun onPause() {
        super.onPause()
        disposables.clear()
    }

    private fun render(imageList: PagedList<ImageItemModel>) {
        imageAdapter.submitList(imageList)
    }


}
