package com.visual.flickerdemo

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image_screen.*

class ImageScreenActivity : AppCompatActivity() {

    @BindView(R.id.iv_full_screen)
    lateinit var ivFullScreen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_screen)
        setSupportActionBar(toolbar)
        ButterKnife.bind(this)

        val imageItemModel = intent?.extras?.get(ITEM_KEY) as ImageItemModel?

        imageItemModel?.apply {
            Glide.with(applicationContext)
                .load(this.imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(ivFullScreen)
        }

    }

}
