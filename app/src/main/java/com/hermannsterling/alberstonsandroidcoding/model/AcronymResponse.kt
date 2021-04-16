package com.hermannsterling.alberstonsandroidcoding.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.QueryName

@JsonClass(generateAdapter = true)
data class AcronymResponse(
    @Json(name = "sf")
    val shortForm: String,
    @Json(name = "lfs")
    val longForms: List<LongForm>
)
