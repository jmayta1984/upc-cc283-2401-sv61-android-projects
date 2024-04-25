package pe.edu.upc.eatsexplorer.feature_restaurant.data.remote

import pe.edu.upc.eatsexplorer.core_network.RetrofitFactory

class RestaurantServiceFactory private constructor() {

    companion object {
        fun getRestaurantService(): RestaurantService {
            return RetrofitFactory.getRetrofit().create(RestaurantService::class.java)
        }
    }
}