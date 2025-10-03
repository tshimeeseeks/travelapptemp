package vcmsa.projects.travelapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Route Planning card → RouteFragment
        val btnRoutePlanning = view.findViewById<TextView>(R.id.btnRoutePlanning)
        btnRoutePlanning.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RouteFragment())
                .addToBackStack(null)
                .commit()
        }

        // TODO: same pattern for Weather, History, Offline if needed

        return view
    }
}
