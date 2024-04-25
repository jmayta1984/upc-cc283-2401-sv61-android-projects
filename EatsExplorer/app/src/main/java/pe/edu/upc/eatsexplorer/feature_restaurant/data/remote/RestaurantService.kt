package pe.edu.upc.eatsexplorer.feature_restaurant.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {

    @GET("restaurants")
    fun getAll(): Call<RestaurantsResponse>
}