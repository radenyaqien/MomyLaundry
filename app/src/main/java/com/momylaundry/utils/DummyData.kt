package com.momylaundry.utils

import com.momylaundry.R
import com.momylaundry.model.CarouselHomeModel
import com.momylaundry.model.LaundryModel
import com.momylaundry.model.ServicesModel

object DummyData {

    fun getListService():ArrayList<ServicesModel>{
        val list = ArrayList<ServicesModel>()

        list.add(
            ServicesModel(1,R.drawable.ic_wash,"Wash",R.color.primary)
        )
        list.add(
            ServicesModel(2,R.drawable.ic_fold,"Fold",R.color.background_fold)
        )
        list.add(
            ServicesModel(3,R.drawable.ic_iron,"Iron",R.color.background_iron)
        )
        list.add(
            ServicesModel(4,R.drawable.ic_dry,"Dry",R.color.background_dry)
        )
        return  list
    }

    fun getListItemLaundry():ArrayList<LaundryModel>{
        val list = ArrayList<LaundryModel>()

        list.add(
            LaundryModel(1,"T-Shirt",R.drawable.ic_tshirt,2)
        )
        list.add(
            LaundryModel(2,"Shirt",R.drawable.ic_shirt,5)
        )
        list.add(
            LaundryModel(3,"Sleeveless",R.drawable.ic_sleeveless,6)
        )
        list.add(
            LaundryModel(4,"Skirt",R.drawable.ic_skirt,3)
        )
        list.add(
            LaundryModel(5,"Polo",R.drawable.ic_polo,4)
        )
        list.add(
            LaundryModel(6,"Suit",R.drawable.ic_suit,8)
        )
        list.add(
            LaundryModel(7,"Jean",R.drawable.ic_jean,3)
        )
        return list
    }

    fun getListCarouse():ArrayList<CarouselHomeModel>{
        val list = ArrayList<CarouselHomeModel>()

        list.add(
            CarouselHomeModel(R.drawable.banner)
        )
        list.add(
            CarouselHomeModel(R.drawable.banner)
        )
        list.add(
            CarouselHomeModel(R.drawable.banner)
        )
        return list
    }
}