package vcmsa.projects.travelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vcmsa.projects.travelapp.data.entity.Trip
import java.text.SimpleDateFormat
import java.util.*

class TripAdapter(private var trips: List<Trip>) : RecyclerView.Adapter<TripAdapter.TripViewHolder>() {
    
    private val dateFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
    
    class TripViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val startLocationText: TextView = view.findViewById(R.id.startLocationText)
        val endLocationText: TextView = view.findViewById(R.id.endLocationText)
        val distanceText: TextView = view.findViewById(R.id.distanceText)
        val durationText: TextView = view.findViewById(R.id.durationText)
        val dateText: TextView = view.findViewById(R.id.dateText)
        val weatherText: TextView = view.findViewById(R.id.weatherText)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trip, parent, false)
        return TripViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val trip = trips[position]
        
        holder.startLocationText.text = "From: ${trip.startLocation}"
        holder.endLocationText.text = "To: ${trip.endLocation}"
        holder.distanceText.text = "Distance: ${trip.distance}"
        holder.durationText.text = "Duration: ${trip.duration}"
        holder.dateText.text = dateFormat.format(Date(trip.createdAt))
        
        if (trip.weatherCondition != null && trip.temperature != null) {
            holder.weatherText.text = "Weather: ${trip.weatherCondition}, ${trip.temperature}"
            holder.weatherText.visibility = View.VISIBLE
        } else {
            holder.weatherText.visibility = View.GONE
        }
    }
    
    override fun getItemCount() = trips.size
    
    fun updateTrips(newTrips: List<Trip>) {
        trips = newTrips
        notifyDataSetChanged()
    }
}
