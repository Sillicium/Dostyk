package com.example.myapplication.ui.history

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data.TemporaryDataClassThreeElement
import com.example.myapplication.databinding.ListItemNotificationDetailsBinding
import com.example.myapplication.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.utils.fragment_utils.SimpleViewHolder

class PaymentHistoryAdapter(context: Context) :
    SimpleAdapter<TemporaryDataClassThreeElement, ListItemNotificationDetailsBinding>(context)  {

    init {
        setItems(items)
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
        holder.binding.tvDescription.setText(data.third)
    }
}