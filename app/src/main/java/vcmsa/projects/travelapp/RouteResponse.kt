package vcmsa.projects.travelapp

data class RouteResponse(
    val features: List<Feature>
)

data class Feature(
    val properties: Properties
)

data class Properties(
    val summary: Summary
)

data class Summary(
    val distance: Double, // in meters
    val duration: Double  // in seconds
)
