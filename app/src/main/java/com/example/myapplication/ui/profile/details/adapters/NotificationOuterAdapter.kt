package com.example.myapplication.ui.profile.details.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data.TemporaryDataClassWithList
import com.example.myapplication.databinding.ListItemNotificationViewBinding
import com.example.myapplication.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.utils.fragment_utils.SimpleViewHolder

class NotificationOuterAdapter(context: Context,
                               items: List<TemporaryDataClassWithList>) :
    SimpleAdapter<TemporaryDataClassWithList, ListItemNotificationViewBinding>(context)  {


    override fun getBinding(parent: ViewGroup): ListItemNotificationViewBinding =
        ListItemNotificationViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun onBindViewHolder(
        holder: SimpleViewHolder<ListItemNotificationViewBinding>,
        position: Int
    ) {
        val data = items[position]
        holder.binding.tvNotificationDate.setText(data.first)
        holder.binding.notificationDetailsList.adapter = NotificationInnerAdapter(data.second)

    }
}