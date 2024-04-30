package pe.edu.upc.eatsexplorer.feature_restaurant.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class RestaurantEntity(
    @PrimaryKey
    val id: Int
)
