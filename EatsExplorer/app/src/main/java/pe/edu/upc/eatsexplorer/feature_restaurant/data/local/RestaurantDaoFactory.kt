package pe.edu.upc.eatsexplorer.feature_restaurant.data.local

import pe.edu.upc.eatsexplorer.MyApplication
import pe.edu.upc.eatsexplorer.core_database.AppDatabase

class RestaurantDaoFactory private constructor(){
    companion object {

        fun getRestaurantDao(): RestaurantDao {
            return AppDatabase.getInstance(MyApplication.getContext()).getRestaurantDao()
        }
    }
}