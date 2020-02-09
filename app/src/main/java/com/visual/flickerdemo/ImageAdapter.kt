package com.visual.flickerdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import javax.inject.Inject

class ImageAdapter @Inject constructor(
    private val imageClickListener: ImageClickListener
) : ListAdapter<ImageItemModel, ImageViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        val binding: ViewDataBinding = inflate(
            LayoutInflater.from(parent.context),
            R.layout.image_item,
            parent,
            false
        )
        return ImageViewHolder(imageClickListener, binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<ImageItemModel>() {
            override fun areItemsTheSame(
                oldItem: ImageItemModel,
                newItem: ImageItemModel
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ImageItemModel,
                newItem: ImageItemModel
            ): Boolean =
                oldItem == newItem
        }
    }


}