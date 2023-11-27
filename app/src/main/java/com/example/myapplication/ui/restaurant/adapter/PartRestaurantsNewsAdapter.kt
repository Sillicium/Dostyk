package com.example.myapplication.ui.restaurant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.data.TemporaryDataClassTwoElement
import com.example.myapplication.databinding.ListItemRestaurantDetailsNewsAndEventsBinding
import com.example.myapplication.utils.fragment_utils.SimpleAdapter
import com.example.myapplication.utils.fragment_utils.SimpleViewHolder
import javax.xml.transform.ErrorListener

class PartRestaurantsNewsAdapter(context: Context,
                                private val listener: PartRestaurantsNewsAdapterClickListener ) :
    SimpleAdapter<TemporaryDataClassTwoElement, ListItemRestaurantDetailsNewsAndEventsBinding>(context) {

        interface PartRestaurantsNewsAdapterClickListener{
            fun userClickListener()
        }

    override fun getBinding(parent: ViewGroup): ListItemRestaurantDetailsNewsAndEventsBinding =
        ListItemRestaurantDetailsNewsAndEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun onBindViewHolder(
        holder: SimpleViewHolder<ListItemRestaurantDetailsNewsAndEventsBinding>,
        position: Int
    ) {
        val data = items[position]
        holder.binding.ivRestaurantDescriptionNewsAndEvent.setImageResource(data.first)
        holder.binding.tvRestaurantDescriptionText.setText(data.second)

        holder.binding.ivRestaurantDescriptionNewsAndEventLayout
            .setOnClickListener {
                listener.userClickListener()
            }
    }
}