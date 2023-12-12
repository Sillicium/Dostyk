package com.example.myapplication.presentation_layer.ui.restaurant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data_layer.model.TemporaryDataClassTwoElement
import com.example.myapplication.databinding.ListItemNotificationDetailsBinding
import com.example.myapplication.presentation_layer.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.presentation_layer.utils.fragment_utils.SimpleViewHolder

class AllRestaurantNewsAdapter(context: Context,
                               private val listener: AllRestaurantNewsAdapterUserClickListener) :
    SimpleAdapter<TemporaryDataClassTwoElement, ListItemNotificationDetailsBinding>(context) {

    interface AllRestaurantNewsAdapterUserClickListener{
        fun onItemClickListener()
    }

    override fun getBinding(parent: ViewGroup): ListItemNotificationDetailsBinding =
        ListItemNotificationDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun onBindViewHolder(
        holder: SimpleViewHolder<ListItemNotificationDetailsBinding>,
        position: Int
    ) {
        val data = items[position]
        holder.binding.ivNotificationSendCompany.setImageResource(data.first)
        holder.binding.tvTitle.setText(data.second)
        holder.binding.tvDescription.setText(data.second)

        holder.binding.layout.setOnClickListener {
            listener.onItemClickListener()
        }
    }
}