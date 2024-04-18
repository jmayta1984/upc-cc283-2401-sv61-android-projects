package pe.edu.upc.superherocompose.factories

import android.content.Context
import androidx.room.Room
import pe.edu.upc.superherocompose.persistence.AppDatabase

class AppDatabaseFactory private constructor() {
    companion object {
        private var appDatabase: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "db")
                    .allowMainThreadQueries()
                    .build()
            }
            return appDatabase as AppDatabase
        }
    }
}