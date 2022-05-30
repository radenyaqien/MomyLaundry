package com.momylaundry.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.momylaundry.databinding.ItemServicesBinding
import com.momylaundry.model.ServicesModel
import com.momylaundry.ui.laundry.LaundryActivity

class HomeServicesAdapter: RecyclerView.Adapter<HomeServicesAdapter.ViewHolder>() {
    private val listService = ArrayList<ServicesModel>()

    fun setData(items:ArrayList<ServicesModel>){
        listService.clear()
        listService.addAll(items)
        this.notifyDataSetChanged()
    }

    class ViewHolder(private val binding:ItemServicesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data:ServicesModel){
            binding.tvNameService.text = data.name
            Glide.with(itemView.context)
                .load(data.image)
                .into(binding.imageService)

            Glide.with(itemView.context)
                .load(data.background)
                .into(binding.backgroundIcon)

            itemView.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,LaundryActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemServicesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listService[position])
    }

    override fun getItemCount(): Int = listService.size
}