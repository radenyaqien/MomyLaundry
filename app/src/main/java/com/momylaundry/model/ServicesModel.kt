package com.momylaundry.model

import android.graphics.drawable.ColorDrawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServicesModel(
    var id: Int?=0,
    var image: Int?=0,
    var name: String?=null,
    var background:Int?=0
) : Parcelable
