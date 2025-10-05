package vcmsa.projects.travelapp.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import vcmsa.projects.travelapp.data.entity.CachedRoute

@Dao
interface CachedRouteDao {
    
    @Query("SELECT * FROM cached_routes WHERE userId = :userId ORDER BY cachedAt DESC")
    fun getAllCachedRoutes(userId: String): Flow<List<CachedRoute>>
    
    @Query("SELECT * FROM cached_routes WHERE userId = :userId ORDER BY cachedAt DESC LIMIT :limit")
    fun getRecentCachedRoutes(userId: String, limit: Int = 10): Flow<List<CachedRoute>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCachedRoute(route: CachedRoute): Long
    
    @Delete
    suspend fun deleteCachedRoute(route: CachedRoute)
    
    @Query("DELETE FROM cached_routes WHERE userId = :userId")
    suspend fun deleteAllCachedRoutes(userId: String)
    
    @Query("DELETE FROM cached_routes WHERE cachedAt < :timestamp")
    suspend fun deleteOldCachedRoutes(timestamp: Long)
}
