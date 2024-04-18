package pe.edu.upc.superherocompose.factories

import pe.edu.upc.superherocompose.repositories.HeroRepository

class HeroRepositoryFactory private constructor() {
    companion object {
        private var heroRepository: HeroRepository? = null

        fun getHeroRepository(): HeroRepository {
            if (heroRepository == null) {
                heroRepository = HeroRepository(
                    HeroServiceFactory.getHeroService(), HeroDaoFactory.getHeroDao()
                )
            }
            return heroRepository as HeroRepository
        }

    }
}