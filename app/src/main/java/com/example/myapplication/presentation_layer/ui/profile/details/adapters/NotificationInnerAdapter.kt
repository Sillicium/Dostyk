package com.example.myapplication.presentation_layer.ui.profile.details.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data_layer.model.TemporaryDataClassThreeElement
import com.example.myapplication.databinding.ListItemNotificationDetailsBinding

class NotificationInnerAdapter(private val values: List<TemporaryDataClassThreeElement>,) :
     RecyclerView.Adapter<NotificationInnerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ListItemNotificationDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = values[position]
        holder.IvIcon.setImageResource(data.first)
        holder.tvTitle.setText(data.second)
        holder.tvText.setText(data.third)
    }

    inner class ViewHolder(binding: ListItemNotificationDetailsBinding):
        RecyclerView.ViewHolder(binding.root){
        val IvIcon = binding.ivNotificationSendCompany
        val tvTitle = binding.tvTitle
        val tvText = binding.tvDescription
    }
}