package vcmsa.projects.travelapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached_weather")
data class CachedWeather(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val locationName: String,
    val latitude: Double,
    val longitude: Double,
    val temperature: Double,
    val weatherCondition: String,
    val humidity: Int,
    val windSpeed: Double,
    val forecastType: String, // "current" or "forecast"
    val cachedAt: Long = System.currentTimeMillis()
)
