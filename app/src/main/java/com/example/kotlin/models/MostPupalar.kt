package com.example.kotlin.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MostPupalar(
    @SerializedName("id")
    val id: String?,

    @SerializedName("release_date")
    val fecha: String?,

    @SerializedName("title")
    val titulo: String?,

    @SerializedName("poster_path")
    val img: String?,

    @SerializedName("overview")
    val info: String?,

    ) : Parcelable {
    constructor() : this("", "", "", "", "")
}
