package com.visual.flickerdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class ImageAdapter : PagedListAdapter<ImageItemModel, ImageViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding: ViewDataBinding = inflate(
            LayoutInflater.from(parent.context),
            R.layout.image_item,
            parent,
            false
        )

        return ImageViewHolder(parent, binding)
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