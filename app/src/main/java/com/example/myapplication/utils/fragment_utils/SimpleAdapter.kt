package com.example.myapplication.utils.fragment_utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.util.Collections



abstract class SimpleAdapter<T, B : ViewBinding>(protected val context: Context) :
    RecyclerView.Adapter<SimpleViewHolder<B>>() {
    protected var items: List<T> = Collections.emptyList()
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    var onClick: (item: T) -> Unit = {}

    fun silentSetItems(items: List<T>) {
        this.items = items
    }

    @JvmName("setAllItems")
    fun setItems(items: List<T>){
        silentSetItems(items)
        notifyDataSetChanged()
    }

    fun onItemClick(onItemClick: ((position: Int, view: View) -> Unit)?) {
        this.onItemClick = onItemClick
    }

    fun onClick(onClickValue: (item: T) -> Unit){
        this.onClick = onClickValue
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): T? {
        if (position in items.indices) {
            return items[position]
        }
        return null
    }

    abstract fun getBinding(parent: ViewGroup): B

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder<B> {
        return SimpleViewHolder(getBinding(parent))
    }
}