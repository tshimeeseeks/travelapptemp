# Guide Travel App - Setup & Configuration Guide

## Prerequisites
- Android Studio (Arctic Fox or later)
- JDK 11 or higher
- Android SDK (API 26+)
- Google Cloud Console account
- OpenWeatherMap account

## Step 1: Clone & Open Project
```bash
git clone https://github.com/tshimeeseeks/travelapptemp.git
cd travelapptemp
```
Open the project in Android Studio and let Gradle sync.

## Step 2: Get API Keys

### 2.1 Google Maps API Key
1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project or select existing
3. Enable the following APIs:
   - Maps SDK for Android
   - Directions API
   - Places API
4. Go to "Credentials" → "Create Credentials" → "API Key"
5. Copy your API key

### 2.2 OpenWeatherMap API Key
1. Go to [OpenWeatherMap](https://openweathermap.org/api)
2. Sign up for free account
3. Go to "API keys" section
4. Copy your API key

## Step 3: Configure API Keys

### 3.1 Google Maps API
**File:** `app/src/main/AndroidManifest.xml`

Find this line:
```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_GOOGLE_MAPS_API_KEY" />
```

Replace `YOUR_GOOGLE_MAPS_API_KEY` with your actual key:
```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="AIza..." />
```

### 3.2 OpenWeatherMap API
**File:** `app/src/main/java/vcmsa/projects/travelapp/WeatherFragment.kt`

Find this line:
```kotlin
private val WEATHER_API_KEY = "YOUR_OPENWEATHERMAP_API_KEY"
```

Replace with your actual key:
```kotlin
private val WEATHER_API_KEY = "your_actual_api_key_here"
```

## Step 4: Firebase Setup (Already configured)
The project already has Firebase configured with:
- Firebase Authentication
- Cloud Firestore

If you want to use your own Firebase project:
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project
3. Add Android app with package name: `vcmsa.projects.travelapp`
4. Download `google-services.json`
5. Replace the existing `app/google-services.json`

## Step 5: Build & Run

### Sync Gradle
```bash
./gradlew clean
./gradlew build
```

### Run on Emulator/Device
1. Connect Android device or start emulator
2. Click "Run" in Android Studio
3. Select target device
4. Wait for build and installation

## Step 6: Test Features

### Test Authentication
1. Launch app
2. Sign up with email/password
3. Sign in with credentials

### Test Weather
1. Navigate to Weather tab
2. Enter city name (e.g., "London")
3. Click "Check Weather"
4. Verify weather data displays

### Test Route Planning
1. Navigate to Routes tab
2. Enter start location
3. Enter destination
4. View route details

### Test Trip History
1. Navigate to History tab
2. View saved trips
3. Verify trip details display

## Troubleshooting

### Issue: Maps not displaying
**Solution:** 
- Verify Google Maps API key is correct
- Check API is enabled in Google Cloud Console
- Ensure billing is enabled (required for Maps API)

### Issue: Weather not loading
**Solution:**
- Verify OpenWeatherMap API key is correct
- Check internet connection
- API may have rate limits on free tier

### Issue: Build errors
**Solution:**
```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

### Issue: KSP errors
**Solution:**
- Update Android Studio to latest version
- Sync Gradle files
- Invalidate caches: File → Invalidate Caches / Restart

## Project Structure
```
app/
├── src/main/
│   ├── java/vcmsa/projects/travelapp/
│   │   ├── data/
│   │   │   ├── entity/          # Room entities
│   │   │   ├── dao/             # Database access objects
│   │   │   ├── model/           # API response models
│   │   │   ├── database/        # Database configuration
│   │   │   └── repository/      # Data repositories
│   │   ├── api/                 # API service interfaces
│   │   ├── network/             # Retrofit configuration
│   │   ├── *Fragment.kt         # UI fragments
│   │   └── *Activity.kt         # Activities
│   └── res/
│       └── layout/              # XML layouts
└── build.gradle.kts             # Dependencies
```

## Features Implemented

✅ **Database Layer**
- Room database with Trip, CachedRoute, CachedWeather entities
- DAOs for all database operations
- Repository pattern for data management

✅ **Weather Integration**
- OpenWeatherMap API integration
- Real-time weather data
- Weather caching for offline access

✅ **Google Maps Setup**
- Directions API integration
- Location permissions configured
- Route models and services ready

✅ **Trip History**
- RecyclerView with trip cards
- Date formatting
- Weather data display

✅ **Offline Mode Foundation**
- Route caching
- Weather caching
- Data persistence

## Known Limitations

1. **Maps UI Not Implemented**: RouteFragment needs Google Maps view integration
2. **Network Detection**: Offline mode needs connectivity detection
3. **Places Autocomplete**: Not yet implemented in RouteFragment
4. **Trip Saving**: Route → Trip conversion needs implementation

## Next Development Steps

1. Add Google Maps MapView to RouteFragment
2. Implement Places Autocomplete
3. Add network connectivity detection
4. Implement trip saving from routes
5. Add polyline rendering on map
6. Implement recent searches

## Support
For issues, check:
- [Android Documentation](https://developer.android.com/)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Google Maps Documentation](https://developers.google.com/maps)

## License
This project follows the planning document specifications.
