package vcmsa.projects.travelapp.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import vcmsa.projects.travelapp.data.entity.Trip

@Dao
interface TripDao {
    
    @Query("SELECT * FROM trips WHERE userId = :userId ORDER BY createdAt DESC")
    fun getAllTrips(userId: String): Flow<List<Trip>>
    
    @Query("SELECT * FROM trips WHERE id = :tripId")
    suspend fun getTripById(tripId: Long): Trip?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrip(trip: Trip): Long
    
    @Update
    suspend fun updateTrip(trip: Trip)
    
    @Delete
    suspend fun deleteTrip(trip: Trip)
    
    @Query("DELETE FROM trips WHERE userId = :userId")
    suspend fun deleteAllTrips(userId: String)
    
    @Query("SELECT * FROM trips WHERE userId = :userId AND completedAt IS NOT NULL ORDER BY completedAt DESC LIMIT :limit")
    fun getRecentCompletedTrips(userId: String, limit: Int = 10): Flow<List<Trip>>
}
