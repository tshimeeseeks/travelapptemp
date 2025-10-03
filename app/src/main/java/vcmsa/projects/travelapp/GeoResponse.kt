package vcmsa.projects.travelapp

data class GeoResponse(
    val features: List<GeoFeature>
)

data class GeoFeature(
    val geometry: GeoGeometry
)

data class GeoGeometry(
    val coordinates: List<Double> // [lng, lat]
)
