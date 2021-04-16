package repo

import com.hermannsterling.alberstonsandroidcoding.model.AcronymResponse
import repo.remote.AcronymService
import retrofit2.Response
import javax.inject.Inject


class AcronymRepo @Inject constructor(
    private val acronymService: AcronymService,
) {
    suspend fun getAcronymResult(
        acronym: String
    ): Response<List<AcronymResponse>> = acronymService.getAcronymResult(acronym)

}