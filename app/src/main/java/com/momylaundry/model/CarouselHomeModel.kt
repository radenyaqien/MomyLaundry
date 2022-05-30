package com.momylaundry.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarouselHomeModel(
    var image:Int?=0
) : Parcelable
