package vcmsa.projects.travelapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "trips")
data class Trip(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String,
    val startLocation: String,
    val startLatitude: Double,
    val startLongitude: Double,
    val endLocation: String,
    val endLatitude: Double,
    val endLongitude: Double,
    val distance: String,
    val duration: String,
    val weatherCondition: String?,
    val temperature: String?,
    val createdAt: Long = System.currentTimeMillis(),
    val completedAt: Long? = null
)
