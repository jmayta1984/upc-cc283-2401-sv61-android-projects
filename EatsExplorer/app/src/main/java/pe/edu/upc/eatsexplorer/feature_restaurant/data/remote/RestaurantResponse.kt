package pe.edu.upc.eatsexplorer.feature_restaurant.data.remote

typealias RestaurantsResponse = List<RestaurantResponse>
data class RestaurantResponse(
    val id: Int,
    val title: String,
    val poster: String
)
