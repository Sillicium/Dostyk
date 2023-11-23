package com.example.myapplication.ui.history

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data.TemporaryDataClassTextAndIcon
import com.example.myapplication.databinding.ListItemTopBrandsBinding
import com.example.myapplication.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.utils.fragment_utils.SimpleViewHolder

class TopBrandsAdapter(context: Context) :
    SimpleAdapter<TemporaryDataClassTextAndIcon, ListItemTopBrandsBinding>(context)  {

    override fun getBinding(parent: ViewGroup): ListItemTopBrandsBinding =
        ListItemTopBrandsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun onBindViewHolder(
        holder: SimpleViewHolder<ListItemTopBrandsBinding>,
        position: Int
    ) {
        val data = items[position]
        holder.binding.ivTopBrand.setImageResource(data.icon)
        holder.binding.tvTopBrand.setText(data.title)
    }
}