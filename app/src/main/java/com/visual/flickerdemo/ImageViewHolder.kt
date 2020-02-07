package com.visual.flickerdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView

class ImageViewHolder(parent: ViewGroup, val binding: ViewDataBinding) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
) {

    fun bind(imageItemModel: ImageItemModel?) {
        binding.setVariable(BR.viewModel, imageItemModel)
        binding.executePendingBindings()
    }
}