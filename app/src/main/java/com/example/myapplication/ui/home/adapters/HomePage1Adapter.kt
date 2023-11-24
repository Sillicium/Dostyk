package com.example.myapplication.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data.TemporaryDataClassOneElement
import com.example.myapplication.data.TemporaryDataClassTwoElement
import com.example.myapplication.databinding.ListItemHomePage1Binding
import com.example.myapplication.databinding.ListItemNewPlacesBinding
import com.example.myapplication.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.utils.fragment_utils.SimpleViewHolder

class HomePage1Adapter(context: Context) :
    SimpleAdapter<TemporaryDataClassOneElement, ListItemHomePage1Binding>(context) {

    override fun getBinding(parent: ViewGroup): ListItemHomePage1Binding =
        ListItemHomePage1Binding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun onBindViewHolder(
        holder: SimpleViewHolder<ListItemHomePage1Binding>,
        position: Int
    ) {
        val data = items[position]

        holder.binding.ivImage.setImageResource(data.first)
    }


}