package com.visual.flickerdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), ImageClickListener {

    private val imageAdapter: ImageAdapter = ImageAdapter(this)

    @Inject
    lateinit var imageViewModel: ImageListViewModel

    @Inject
    lateinit var imageViewModelFactory: ImageViewModelFactory

    @BindView(R.id.rv_images)
    lateinit var rvImages: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        rvImages.adapter = imageAdapter
        imageViewModel =
            ViewModelProviders.of(this, imageViewModelFactory).get(ImageListViewModel::class.java)

        val imageListObserver = Observer<List<ImageItemModel>> { imageList ->

            renderList(imageList)
        }

        val errorObserver = Observer<String> { error -> renderError(error) }

        imageViewModel.getImages().observe(this, imageListObserver)

        imageViewModel.getError().observe(this, errorObserver)

        setupScroll()
    }

    override fun imageClick(id: String) {
        val clickedItem = imageViewModel.getImages().value!!.firstOrNull { it.id == id }
        startActivity(
            Intent(this, ImageScreenActivity::class.java).putExtra(
                ITEM_KEY, clickedItem
            )
        )
    }

    private fun setupScroll() {

        val scrollListener = object :
            EndlessRecyclerViewScrollListener(rv_images.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {

                imageViewModel.fetchImages()

            }
        }

        rvImages.addOnScrollListener(scrollListener)
    }

    private fun renderList(imageList: List<ImageItemModel>) {
        imageAdapter.submitList(imageList)

    }

    private fun renderError(errorMessage: String) {
        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
    }


}
