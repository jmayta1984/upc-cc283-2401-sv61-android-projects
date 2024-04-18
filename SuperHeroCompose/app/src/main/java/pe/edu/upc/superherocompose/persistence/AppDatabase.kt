package pe.edu.upc.superherocompose.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.superherocompose.model.local.HeroDao
import pe.edu.upc.superherocompose.model.local.HeroEntity

@Database(entities = [HeroEntity::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
}