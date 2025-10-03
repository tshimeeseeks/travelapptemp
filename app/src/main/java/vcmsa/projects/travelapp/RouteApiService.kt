package vcmsa.projects.travelapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RouteApiService {
    @GET("v2/directions/driving-car")
    fun getRoute(
        @Query("api_key") apiKey: String,
        @Query("start") start: String,  // "lng,lat"
        @Query("end") end: String       // "lng,lat"
    ): Call<RouteResponse>
}
