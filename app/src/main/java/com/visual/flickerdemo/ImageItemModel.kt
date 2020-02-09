package com.visual.flickerdemo


import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageItemModel(val id: String, val imageUrl: String) : Parcelable {

   companion object{
       @JvmStatic
       @BindingAdapter("imageUrl")
       fun loadImage(view: ImageView, url: String) {

           if (!url.isNullOrEmpty())
               Glide.with(view.context).load(url).placeholder(R.drawable.placeholder).into(view)
       }
   }

}