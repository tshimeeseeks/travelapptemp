package vcmsa.projects.travelapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoApiService {
    @GET("geocode/search")
    fun searchLocation(
        @Query("api_key") apiKey: String,
        @Query("text") location: String
    ): Call<GeoResponse>
}

