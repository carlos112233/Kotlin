package com.example.kotlin.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MostPopularResponse(

    @SerializedName("results")
    val results: List<MostPupalar>,

    ) : Parcelable {
    constructor() : this(mutableListOf())
}
