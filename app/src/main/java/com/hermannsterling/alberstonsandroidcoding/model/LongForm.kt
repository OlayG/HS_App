package com.hermannsterling.alberstonsandroidcoding.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class LongForm(
    val lf: String,
    val freq: Long,
    val since: Int,
    val vars: List<Var>
): Parcelable
