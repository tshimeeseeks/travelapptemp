package vcmsa.projects.travelapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class OfflineFragment : Fragment() {

    private lateinit var offlineInfo: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment_offline.xml layout
        val view = inflater.inflate(R.layout.fragment_offline, container, false)

        // Bind the TextView
        offlineInfo = view.findViewById(R.id.offlineInfo)

        // Example: update the text dynamically
        val recentRoutes = listOf("Campus → Mall", "Station → Home") // dummy data
        if (recentRoutes.isNotEmpty()) {
            offlineInfo.text = "Recent searches:\n" + recentRoutes.joinToString("\n")
        } else {
            offlineInfo.text = "No offline data available yet."
        }

        return view
    }
}
