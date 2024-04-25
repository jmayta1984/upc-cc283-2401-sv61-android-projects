package pe.edu.upc.eatsexplorer.feature_restaurant.domain

typealias Restaurants = List<Restaurant>
data class Restaurant(
    val name: String,
    val url: String
)