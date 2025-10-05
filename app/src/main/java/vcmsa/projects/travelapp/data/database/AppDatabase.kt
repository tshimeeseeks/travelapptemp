package vcmsa.projects.travelapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vcmsa.projects.travelapp.data.dao.CachedRouteDao
import vcmsa.projects.travelapp.data.dao.CachedWeatherDao
import vcmsa.projects.travelapp.data.dao.TripDao
import vcmsa.projects.travelapp.data.entity.CachedRoute
import vcmsa.projects.travelapp.data.entity.CachedWeather
import vcmsa.projects.travelapp.data.entity.Trip

@Database(
    entities = [Trip::class, CachedRoute::class, CachedWeather::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun tripDao(): TripDao
    abstract fun cachedRouteDao(): CachedRouteDao
    abstract fun cachedWeatherDao(): CachedWeatherDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "guide_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
