package vcmsa.projects.travelapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached_routes")
data class CachedRoute(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val startLocation: String,
    val startLatitude: Double,
    val startLongitude: Double,
    val endLocation: String,
    val endLatitude: Double,
    val endLongitude: Double,
    val polylineData: String, // Encoded polyline from Google Directions API
    val distance: String,
    val duration: String,
    val cachedAt: Long = System.currentTimeMillis()
)
