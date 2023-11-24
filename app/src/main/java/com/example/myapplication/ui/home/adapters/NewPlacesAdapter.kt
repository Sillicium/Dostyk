package com.example.myapplication.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data.TemporaryDataClassTwoElement
import com.example.myapplication.databinding.ListItemNewPlacesBinding
import com.example.myapplication.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.utils.fragment_utils.SimpleViewHolder

class NewPlacesAdapter(context: Context) :
    SimpleAdapter<TemporaryDataClassTwoElement, ListItemNewPlacesBinding>(context) {

    override fun getBinding(parent: ViewGroup): ListItemNewPlacesBinding =
        ListItemNewPlacesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun onBindViewHolder(
        holder: SimpleViewHolder<ListItemNewPlacesBinding>,
        position: Int
    ) {
        val data = items[position]
        holder.binding.ivNewPlaces.setImageResource(data.first)
        holder.binding.tvNewPlaces.setText(data.second)
    }
}