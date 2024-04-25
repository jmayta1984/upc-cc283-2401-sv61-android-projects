package pe.edu.upc.eatsexplorer.feature_restaurant.data.repository

import android.util.Log
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantService
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantServiceFactory
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantsResponse
import pe.edu.upc.eatsexplorer.feature_restaurant.domain.Restaurant
import pe.edu.upc.eatsexplorer.feature_restaurant.domain.Restaurants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantRepository(private val restaurantService: RestaurantService = RestaurantServiceFactory.getRestaurantService()) {

    fun getAll(callback: (Restaurants) -> Unit) {
        val getAll = restaurantService.getAll()

        getAll.enqueue(object : Callback<RestaurantsResponse> {
            override fun onResponse(
                call: Call<RestaurantsResponse>,
                response: Response<RestaurantsResponse>
            ) {
                if (response.isSuccessful) {
                    val restaurantsResponse = response.body() as RestaurantsResponse
                    var restaurants: Restaurants = arrayListOf()
                    for (restaurantResponse in restaurantsResponse) {
                        restaurants = restaurants + Restaurant(
                            restaurantResponse.title,
                            restaurantResponse.poster
                        )
                    }
                    callback(restaurants)
                }
            }

            override fun onFailure(call: Call<RestaurantsResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("RestaurantRepository", it)
                }
            }
        })
    }
}