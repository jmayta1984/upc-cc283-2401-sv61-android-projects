package pe.edu.upc.eatsexplorer.feature_restaurant.data.local

import androidx.room.Entity

@Entity(tableName = "restaurants")
data class RestaurantEntity(
    val id: Int
)
