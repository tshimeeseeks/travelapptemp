package vcmsa.projects.travelapp.data.repository

import vcmsa.projects.travelapp.api.GoogleDirectionsApiService
import vcmsa.projects.travelapp.data.dao.CachedRouteDao
import vcmsa.projects.travelapp.data.entity.CachedRoute
import vcmsa.projects.travelapp.data.model.DirectionsResponse
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.TimeUnit

class RouteRepository(
    private val directionsApi: GoogleDirectionsApiService,
    private val cachedRouteDao: CachedRouteDao,
    private val apiKey: String
) {
    
    companion object {
        private val CACHE_EXPIRY_MILLIS = TimeUnit.DAYS.toMillis(7) // 7 days cache
    }
    
    suspend fun getDirections(
        origin: String,
        destination: String,
        forceRefresh: Boolean = false
    ): DirectionsResponse? {
        return try {
            // Fetch from API
            val response = directionsApi.getDirections(
                origin = origin,
                destination = destination,
                apiKey = apiKey
            )
            
            response
        } catch (e: Exception) {
            null
        }
    }
    
    suspend fun cacheRoute(
        userId: String,
        startLocation: String,
        startLat: Double,
        startLng: Double,
        endLocation: String,
        endLat: Double,
        endLng: Double,
        polylineData: String,
        distance: String,
        duration: String
    ): Long {
        val cachedRoute = CachedRoute(
            userId = userId,
            startLocation = startLocation,
            startLatitude = startLat,
            startLongitude = startLng,
            endLocation = endLocation,
            endLatitude = endLat,
            endLongitude = endLng,
            polylineData = polylineData,
            distance = distance,
            duration = duration
        )
        return cachedRouteDao.insertCachedRoute(cachedRoute)
    }
    
    fun getAllCachedRoutes(userId: String): Flow<List<CachedRoute>> {
        return cachedRouteDao.getAllCachedRoutes(userId)
    }
    
    fun getRecentCachedRoutes(userId: String, limit: Int = 10): Flow<List<CachedRoute>> {
        return cachedRouteDao.getRecentCachedRoutes(userId, limit)
    }
    
    suspend fun clearExpiredCache() {
        val expiryTime = System.currentTimeMillis() - CACHE_EXPIRY_MILLIS
        cachedRouteDao.deleteOldCachedRoutes(expiryTime)
    }
    
    suspend fun deleteAllCachedRoutes(userId: String) {
        cachedRouteDao.deleteAllCachedRoutes(userId)
    }
}
