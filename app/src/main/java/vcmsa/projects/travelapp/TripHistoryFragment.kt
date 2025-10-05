package vcmsa.projects.travelapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import vcmsa.projects.travelapp.data.database.AppDatabase
import vcmsa.projects.travelapp.data.repository.TripRepository

class TripHistoryFragment : Fragment() {
    
    private lateinit var tripRepository: TripRepository
    private lateinit var recyclerView: RecyclerView
    private lateinit var tripAdapter: TripAdapter
    private val auth = FirebaseAuth.getInstance()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_trip_history, container, false)
        
        initializeRepository()
        initializeViews(view)
        loadTrips()
        
        return view
    }
    
    private fun initializeRepository() {
        val database = AppDatabase.getDatabase(requireContext())
        tripRepository = TripRepository(database.tripDao())
    }
    
    private fun initializeViews(view: View) {
        recyclerView = view.findViewById(R.id.tripsRecyclerView)
        tripAdapter = TripAdapter(emptyList())
        
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = tripAdapter
        }
    }
    
    private fun loadTrips() {
        val userId = auth.currentUser?.uid ?: return
        
        lifecycleScope.launch {
            tripRepository.getAllTrips(userId).collectLatest { trips ->
                tripAdapter.updateTrips(trips)
            }
        }
    }
}
