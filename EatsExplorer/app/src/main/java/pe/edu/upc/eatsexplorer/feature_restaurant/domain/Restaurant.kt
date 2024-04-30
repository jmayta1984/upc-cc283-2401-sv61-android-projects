package pe.edu.upc.eatsexplorer.feature_restaurant.domain

typealias Restaurants = List<Restaurant>
data class Restaurant(
    val id: Int,
    val name: String,
    val url: String,
    var isFavorite: Boolean = false
)