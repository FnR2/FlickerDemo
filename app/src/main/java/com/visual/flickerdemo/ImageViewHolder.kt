package com.visual.flickerdemo

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


class ImageViewHolder(
    private val imageClickListener: ImageClickListener,
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: ImageItemModel) {

        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings();
        binding.root.setOnClickListener {
            imageClickListener.imageClick(viewModel.id)
        }
    }
}