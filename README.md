# Guide - Travel Planning App 🌍

A comprehensive Android travel planning application with route optimization, weather integration, and offline capabilities.

## Overview

Guide is a mobile application designed to enhance efficiency, safety, and convenience of personal travel planning. The app combines route planning, real-time weather data, trip history, and offline mode into a single, user-friendly interface.

## Features

### ✅ Implemented
- **User Authentication** - Firebase Authentication with email/password
- **Route Planning** - Google Directions API integration for optimal routes
- **Weather Integration** - Real-time weather data from OpenWeatherMap
- **Trip History** - SQLite/Room database for storing past trips
- **Offline Mode** - Cached routes and weather data for offline access
- **Material Design UI** - Modern, intuitive user interface

### 🚧 In Progress
- Google Maps visualization in RouteFragment
- Places autocomplete for location search
- Network connectivity detection
- Trip saving from routes
- Polyline rendering on maps

## Tech Stack

- **Language:** Kotlin
- **Database:** Room (SQLite)
- **Networking:** Retrofit, OkHttp
- **Maps:** Google Maps SDK, Directions API
- **Weather:** OpenWeatherMap API
- **Authentication:** Firebase Auth
- **UI:** Material Design Components

## Quick Start

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 11+
- Android SDK API 26+
- Google Cloud account (for Maps API)
- OpenWeatherMap account

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/tshimeeseeks/travelapptemp.git
cd travelapptemp
```

2. **Configure API Keys**

**Google Maps API** in `app/src/main/AndroidManifest.xml`:
```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_GOOGLE_MAPS_API_KEY" />
```

**OpenWeatherMap API** in `WeatherFragment.kt`:
```kotlin
private val WEATHER_API_KEY = "YOUR_OPENWEATHERMAP_API_KEY"
```

3. **Build and Run**
```bash
./gradlew clean build
```

See [SETUP_GUIDE.md](SETUP_GUIDE.md) for detailed configuration instructions.

## Project Structure

```
travelapptemp/
├── app/src/main/
│   ├── java/vcmsa/projects/travelapp/
│   │   ├── data/
│   │   │   ├── entity/          # Room database entities
│   │   │   ├── dao/             # Data Access Objects
│   │   │   ├── model/           # API response models
│   │   │   ├── database/        # Database configuration
│   │   │   └── repository/      # Data layer logic
│   │   ├── api/                 # API service interfaces
│   │   ├── network/             # Network configuration
│   │   └── *.kt                 # Activities & Fragments
│   └── res/layout/              # UI layouts
├── IMPLEMENTATION_PROGRESS.md   # Development progress
├── SETUP_GUIDE.md              # Configuration guide
└── build.gradle.kts            # Dependencies
```

## Architecture

The app follows the **Repository Pattern** with:
- **Room Database** for local data persistence
- **Retrofit** for API communication
- **Repositories** for data management
- **LiveData/Flow** for reactive UI updates

## API Integration

### Google Maps APIs
- **Directions API** - Route calculation
- **Places API** - Location search (planned)
- **Maps SDK** - Map visualization (planned)

### OpenWeatherMap API
- Current weather conditions
- Weather forecasting
- Cached for offline access

## Screenshots

_Coming soon_

## Documentation

- [Implementation Progress](IMPLEMENTATION_PROGRESS.md) - Development status
- [Setup Guide](SETUP_GUIDE.md) - Detailed configuration
- [Planning Document](POE_PART_1_PLANNING.pdf) - Original requirements

## Development Team

- **Larsen Claude Canda Nehemia**
- **Mpho Nzibane**
- **Siphesihle Njabulo Zulu**
- **Varlene Zazise Sibanda**

IIE MSA - Group 1

## Roadmap

### Phase 1 ✅ (Complete)
- Database layer with Room
- Entity and DAO setup
- Repository pattern

### Phase 2 ✅ (Complete)
- Weather API integration
- Weather caching
- UI implementation

### Phase 3 ✅ (Complete)
- Google Directions API
- Route models
- Trip history UI

### Phase 4 🚧 (In Progress)
- Google Maps UI integration
- Places autocomplete
- Network detection

### Phase 5 📅 (Planned)
- Enhanced offline mode
- Trip saving workflow
- Recent searches

## Contributing

This is an academic project for OPSC6312 at IIE MSA.

## License

Educational project - IIE MSA 2025

## Support

For setup issues, see [SETUP_GUIDE.md](SETUP_GUIDE.md)

For API documentation:
- [Google Maps](https://developers.google.com/maps/documentation)
- [OpenWeatherMap](https://openweathermap.org/api)
- [Firebase](https://firebase.google.com/docs)

---

**Last Updated:** October 2025
