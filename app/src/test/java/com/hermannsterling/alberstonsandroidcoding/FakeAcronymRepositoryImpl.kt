package com.hermannsterling.alberstonsandroidcoding

import com.hermannsterling.alberstonsandroidcoding.model.AcronymResponse
import com.hermannsterling.alberstonsandroidcoding.model.LongForm
import retrofit2.Response

class FakeAcronymRepositoryImpl {

    private val acronymList = listOf<String>(
        "www",
        "WWW",
        "wWW",
        "wWw",
        "WwW",
        "WWw"
    )
    private val longForms =
        AcronymResponse(
            "sf", listOf<LongForm>(
                LongForm("World Wide Web", 304, 1994, listOf())
            )

        )

//    fun getAcronymResult(acronym: String): List<AcronymResponse> {
//
//        if (acronymList.contains(acronym))
//
//    }
}