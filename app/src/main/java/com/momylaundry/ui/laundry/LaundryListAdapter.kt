package com.momylaundry.ui.laundry

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.momylaundry.R
import com.momylaundry.databinding.ItemLaundryBinding
import com.momylaundry.model.LaundryModel

class LaundryListAdapter(
    private var itemsLaundryCallback: ItemLaundryCallback
) : RecyclerView.Adapter<LaundryListAdapter.ViewHolder>() {
    private var list = ArrayList<LaundryModel>()
    private var qtyItem: Int = 0

    fun setData(items: ArrayList<LaundryModel>) {
        list.clear()
        list.addAll(items)
        this.notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemLaundryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: LaundryModel) {
            Glide.with(itemView.context)
                .load(data.image)
                .error(R.drawable.ic_icon)
                .override(50)
                .into(binding.imageItemLaundry)

            binding.tvNameItemLaundry.text = data.name
            binding.priceItemLaundry.text = "$${data.price}"
            binding.tvCountItem.text = data.quantity.toString()
            Log.d("CHECK IN",data.quantity.toString())
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
        holder.bind(list[position])

        val data = list[position]
        //Minus Item
        holder.binding.actionMinusItem.setOnClickListener {
            if(qtyItem > 0){
                qtyItem --
                Log.d("VALUE MINUS ONE", qtyItem.toString())
            }
        }

        //Plus Item
        holder.binding.actionAddItem.setOnClickListener {
            data.quantity!!.plus(1)
            itemsLaundryCallback.onAddItems(qtyItem)
            Log.d("VALUE PLUS ONE", data.quantity.toString())
            changeQty(holder,data)
            this.notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = list.size

    interface ItemLaundryCallback {
        fun onAddItems(quantity: Int)
    }

    private fun changeQty(holder:ViewHolder,data: LaundryModel){
        holder.binding.tvCountItem.text = qtyItem.toString()
    }
}