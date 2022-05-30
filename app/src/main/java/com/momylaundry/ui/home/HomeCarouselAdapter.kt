package com.momylaundry.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.momylaundry.databinding.ItemsCarouselHomeBinding
import com.momylaundry.model.CarouselHomeModel
import com.smarteist.autoimageslider.SliderViewAdapter

class HomeCarouselAdapter : SliderViewAdapter<HomeCarouselAdapter.ViewHolder>() {
    private var mSliderItems = ArrayList<CarouselHomeModel>()

    fun renewItem(items: ArrayList<CarouselHomeModel>) {
        mSliderItems.clear()
        mSliderItems.addAll(items)
    }

    class ViewHolder(private val binding: ItemsCarouselHomeBinding) :
        SliderViewAdapter.ViewHolder(binding.root) {
        fun bind(data: CarouselHomeModel) {
            Glide.with(itemView.context)
                .load(data.image)
                .into(binding.imageCarousel)
        }
    }

    override fun getCount(): Int = mSliderItems.size

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        return ViewHolder(
            ItemsCarouselHomeBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        viewHolder?.bind(mSliderItems[position])
    }
}