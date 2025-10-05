package vcmsa.projects.travelapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vcmsa.projects.travelapp.api.WeatherApiService
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val ROUTE_BASE_URL = "https://api.openrouteservice.org/"
    private const val WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val routeRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ROUTE_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val weatherRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val routeApi: vcmsa.projects.travelapp.RouteApiService by lazy {
        routeRetrofit.create(vcmsa.projects.travelapp.RouteApiService::class.java)
    }

    val geoApi: vcmsa.projects.travelapp.GeoApiService by lazy {
        routeRetrofit.create(vcmsa.projects.travelapp.GeoApiService::class.java)
    }

    val weatherApi: WeatherApiService by lazy {
        weatherRetrofit.create(WeatherApiService::class.java)
    }
}
