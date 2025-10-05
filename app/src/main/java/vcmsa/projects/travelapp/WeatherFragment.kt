package vcmsa.projects.travelapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.launch
import vcmsa.projects.travelapp.data.database.AppDatabase
import vcmsa.projects.travelapp.data.repository.WeatherRepository
import vcmsa.projects.travelapp.network.RetrofitClient

class WeatherFragment : Fragment() {
    
    private lateinit var weatherRepository: WeatherRepository
    private lateinit var cityInput: EditText
    private lateinit var checkWeatherButton: Button
    private lateinit var weatherCard: MaterialCardView
    private lateinit var locationText: TextView
    private lateinit var temperatureText: TextView
    private lateinit var conditionText: TextView
    private lateinit var humidityText: TextView
    private lateinit var windSpeedText: TextView
    
    // TODO: Replace with your actual OpenWeatherMap API key
    private val WEATHER_API_KEY = "YOUR_OPENWEATHERMAP_API_KEY"
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        
        initializeRepository()
        initializeViews(view)
        setupListeners()
        
        return view
    }
    
    private fun initializeRepository() {
        val database = AppDatabase.getDatabase(requireContext())
        weatherRepository = WeatherRepository(
            RetrofitClient.weatherApi,
            database.cachedWeatherDao(),
            WEATHER_API_KEY
        )
    }
    
    private fun initializeViews(view: View) {
        cityInput = view.findViewById(R.id.cityInput)
        checkWeatherButton = view.findViewById(R.id.checkWeatherButton)
        weatherCard = view.findViewById(R.id.weatherCard)
        locationText = view.findViewById(R.id.locationText)
        temperatureText = view.findViewById(R.id.temperatureText)
        conditionText = view.findViewById(R.id.conditionText)
        humidityText = view.findViewById(R.id.humidityText)
        windSpeedText = view.findViewById(R.id.windSpeedText)
        
        // Hide weather card initially
        weatherCard.visibility = View.GONE
    }
    
    private fun setupListeners() {
        checkWeatherButton.setOnClickListener {
            val city = cityInput.text.toString().trim()
            if (city.isNotEmpty()) {
                fetchWeather(city)
            } else {
                Toast.makeText(requireContext(), "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun fetchWeather(cityName: String) {
        lifecycleScope.launch {
            try {
                checkWeatherButton.isEnabled = false
                checkWeatherButton.text = "Loading..."
                
                val weather = weatherRepository.getWeatherByCity(cityName)
                
                if (weather != null) {
                    displayWeather(weather)
                } else {
                    Toast.makeText(requireContext(), "Weather data not available", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            } finally {
                checkWeatherButton.isEnabled = true
                checkWeatherButton.text = "Check Weather"
            }
        }
    }
    
    private fun displayWeather(weather: vcmsa.projects.travelapp.data.model.WeatherResponse) {
        weatherCard.visibility = View.VISIBLE
        
        locationText.text = "${weather.name}, ${weather.sys.country}"
        temperatureText.text = "${weather.main.temp.toInt()}°C"
        conditionText.text = weather.weather.firstOrNull()?.description?.replaceFirstChar { it.uppercase() } ?: "Unknown"
        humidityText.text = "Humidity: ${weather.main.humidity}%"
        windSpeedText.text = "Wind: ${weather.wind.speed} m/s"
    }
}
