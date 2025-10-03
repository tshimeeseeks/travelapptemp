package vcmsa.projects.travelapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.openrouteservice.org/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val routeApi: RouteApiService by lazy {
        retrofit.create(RouteApiService::class.java)
    }

    val geoApi: GeoApiService by lazy {
        retrofit.create(GeoApiService::class.java)
    }
}
