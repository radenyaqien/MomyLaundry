package com.momylaundry.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaundryModel(
    var id: Int,
    var name:String,
    var image:Int,
    var price:Int,
    var quantity:Int?=0,
    var total:Int=0
) : Parcelable
