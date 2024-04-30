package pe.edu.upc.eatsexplorer.feature_restaurant.data.repository

import android.util.Log
import pe.edu.upc.eatsexplorer.feature_restaurant.data.local.RestaurantDao
import pe.edu.upc.eatsexplorer.feature_restaurant.data.local.RestaurantDaoFactory
import pe.edu.upc.eatsexplorer.feature_restaurant.data.local.RestaurantEntity
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantService
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantServiceFactory
import pe.edu.upc.eatsexplorer.feature_restaurant.data.remote.RestaurantsResponse
import pe.edu.upc.eatsexplorer.feature_restaurant.domain.Restaurant
import pe.edu.upc.eatsexplorer.feature_restaurant.domain.Restaurants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantRepository(
    private val restaurantService: RestaurantService = RestaurantServiceFactory.getRestaurantService(),
    private val restaurantDao: RestaurantDao = RestaurantDaoFactory.getRestaurantDao()
) {

    fun insert(id: Int) {
        restaurantDao.insert(RestaurantEntity(id))
    }

    fun delete(id: Int) {
        restaurantDao.delete(RestaurantEntity(id))
    }

    fun isFavorite(id: Int): Boolean {
        return (restaurantDao.fetchById(id) != null)
    }

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
                            restaurantResponse.id,
                            restaurantResponse.title,
                            restaurantResponse.poster,
                            isFavorite(restaurantResponse.id)
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