package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.MyApplication
import pe.edu.upc.superherocompose.model.local.HeroDao

class HeroDaoFactory private constructor() {

    companion object {
        private var heroDao: HeroDao? = null

        fun getHeroDao(): HeroDao {
            if (heroDao == null) {
                heroDao = AppDatabaseFactory.getAppDatabase(MyApplication.getContext()).heroDao()
            }
            return heroDao as HeroDao
        }
    }
}