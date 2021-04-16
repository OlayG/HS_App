package repo.remote

import com.hermannsterling.alberstonsandroidcoding.model.AcronymResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymService {
    @GET("software/acromine/dictionary.py")
    suspend fun getAcronymResult(@Query("sf") acronym: String): Response<List<AcronymResponse>>

}