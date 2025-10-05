package vcmsa.projects.travelapp.data.model

import com.google.gson.annotations.SerializedName

data class DirectionsResponse(
    @SerializedName("routes")
    val routes: List<Route>,
    @SerializedName("status")
    val status: String
)

data class Route(
    @SerializedName("summary")
    val summary: String,
    @SerializedName("legs")
    val legs: List<Leg>,
    @SerializedName("overview_polyline")
    val overviewPolyline: OverviewPolyline
)

data class Leg(
    @SerializedName("distance")
    val distance: Distance,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("start_address")
    val startAddress: String,
    @SerializedName("end_address")
    val endAddress: String,
    @SerializedName("start_location")
    val startLocation: Location,
    @SerializedName("end_location")
    val endLocation: Location,
    @SerializedName("steps")
    val steps: List<Step>
)

data class Distance(
    @SerializedName("text")
    val text: String,
    @SerializedName("value")
    val value: Int
)

data class Duration(
    @SerializedName("text")
    val text: String,
    @SerializedName("value")
    val value: Int
)

data class Location(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)

data class Step(
    @SerializedName("distance")
    val distance: Distance,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("html_instructions")
    val htmlInstructions: String,
    @SerializedName("polyline")
    val polyline: OverviewPolyline,
    @SerializedName("start_location")
    val startLocation: Location,
    @SerializedName("end_location")
    val endLocation: Location
)

data class OverviewPolyline(
    @SerializedName("points")
    val points: String
)
