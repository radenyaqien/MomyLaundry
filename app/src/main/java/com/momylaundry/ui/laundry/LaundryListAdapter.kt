package com.momylaundry.ui.laundry

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.momylaundry.R
import com.momylaundry.databinding.ItemLaundryBinding
import com.momylaundry.model.LaundryModel

class LaundryListAdapter(
    private val itemsLaundryCallback: ItemLaundryCallback
) : RecyclerView.Adapter<LaundryListAdapter.ViewHolder>() {
    private val list = ArrayList<LaundryModel>()

    val items: List<LaundryModel> get() = list.toList()
    fun setData(items: ArrayList<LaundryModel>) {
        list.clear()
        list.addAll(items)
        this.notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemLaundryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: LaundryModel, position: Int, itemcallback: ItemLaundryCallback) {
            Glide.with(itemView.context)
                .load(data.image)
                .error(R.drawable.ic_icon)
                .override(50)
                .into(binding.imageItemLaundry)
            with(binding) {
                actionAddItem.setOnClickListener {
                    itemcallback.onAddItems(data, position)
                }
                actionMinusItem.setOnClickListener {
                    itemcallback.onMinusItems(data, position)
                }

                this.tvNameItemLaundry.text = data.name
                priceItemLaundry.text = "$${data.price}"
                tvCountItem.text = data.quantity.toString()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLaundryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position, itemsLaundryCallback)
    }

    override fun getItemCount(): Int = list.size

    interface ItemLaundryCallback {
        fun onAddItems(model: LaundryModel, position: Int)
        fun onMinusItems(model: LaundryModel, position: Int)
    }


}