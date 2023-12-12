package com.example.myapplication.presentation_layer.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data_layer.model.TemporaryDataClassTwoElement
import com.example.myapplication.databinding.ListItemTopBrandsBinding
import com.example.myapplication.presentation_layer.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.presentation_layer.utils.fragment_utils.SimpleViewHolder

class TopBrandsAdapter(context: Context) :
    SimpleAdapter<TemporaryDataClassTwoElement, ListItemTopBrandsBinding>(context)  {

    override fun getBinding(parent: ViewGroup): ListItemTopBrandsBinding =
        ListItemTopBrandsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun onBindViewHolder(
        holder: SimpleViewHolder<ListItemTopBrandsBinding>,
        position: Int
    ) {
        val data = items[position]
        holder.binding.ivTopBrand.setImageResource(data.first)
        holder.binding.tvTopBrand.setText(data.second)
    }
}