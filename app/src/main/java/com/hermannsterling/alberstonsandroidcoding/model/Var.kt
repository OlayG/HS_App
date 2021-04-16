package com.hermannsterling.alberstonsandroidcoding.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Var(
    val lf: String,
    val freq: Long,
    val since: Int
) : Parcelable

