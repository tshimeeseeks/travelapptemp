package vcmsa.projects.travelapp.data.repository

import kotlinx.coroutines.flow.Flow
import vcmsa.projects.travelapp.data.dao.TripDao
import vcmsa.projects.travelapp.data.entity.Trip

class TripRepository(private val tripDao: TripDao) {
    
    fun getAllTrips(userId: String): Flow<List<Trip>> {
        return tripDao.getAllTrips(userId)
    }
    
    fun getRecentCompletedTrips(userId: String, limit: Int = 10): Flow<List<Trip>> {
        return tripDao.getRecentCompletedTrips(userId, limit)
    }
    
    suspend fun getTripById(tripId: Long): Trip? {
        return tripDao.getTripById(tripId)
    }
    
    suspend fun insertTrip(trip: Trip): Long {
        return tripDao.insertTrip(trip)
    }
    
    suspend fun updateTrip(trip: Trip) {
        tripDao.updateTrip(trip)
    }
    
    suspend fun deleteTrip(trip: Trip) {
        tripDao.deleteTrip(trip)
    }
    
    suspend fun deleteAllTrips(userId: String) {
        tripDao.deleteAllTrips(userId)
    }
}
