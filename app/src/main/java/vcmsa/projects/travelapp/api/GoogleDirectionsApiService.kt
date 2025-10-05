package vcmsa.projects.travelapp.api

import retrofit2.http.GET
import retrofit2.http.Query
import vcmsa.projects.travelapp.data.model.DirectionsResponse

interface GoogleDirectionsApiService {
    
    @GET("directions/json")
    suspend fun getDirections(
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query("key") apiKey: String,
        @Query("mode") mode: String = "driving",
        @Query("alternatives") alternatives: Boolean = true
    ): DirectionsResponse
}
