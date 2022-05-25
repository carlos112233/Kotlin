package com.example.kotlin.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayingNowResponse(

    @SerializedName("results")
    val results: List<PlayingNow>,

    ) : Parcelable {
    constructor() : this(mutableListOf())
}
