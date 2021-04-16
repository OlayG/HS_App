package repo.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitInstance {
   private val BASE_URL = "http://www.nactem.ac.uk/"


   @Provides
   @Singleton
   fun client(): OkHttpClient = HttpLoggingInterceptor() // Created an HTTPLoggingInterceptor
      .apply {
         level =
            HttpLoggingInterceptor.Level.BODY // Defined the level to be BODY (response body)
      }.let { loginInterceptor ->
         OkHttpClient.Builder().addInterceptor(loginInterceptor)
            .build() // return an instance of an OkHttpClient that has the HTTPLoggingInterceptor
      }

   @Provides
   @Singleton
   fun retrofit(): Retrofit = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(MoshiConverterFactory.create())
      .client(client())
      .build()

   @Provides
   @Singleton
   fun acronymService(): AcronymService = retrofit().create(AcronymService::class.java)

}