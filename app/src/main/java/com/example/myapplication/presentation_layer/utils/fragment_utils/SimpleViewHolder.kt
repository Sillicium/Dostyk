package com.example.myapplication.presentation_layer.utils.fragment_utils

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


class SimpleViewHolder<T: ViewBinding>(val binding: T): RecyclerView.ViewHolder(binding.root)