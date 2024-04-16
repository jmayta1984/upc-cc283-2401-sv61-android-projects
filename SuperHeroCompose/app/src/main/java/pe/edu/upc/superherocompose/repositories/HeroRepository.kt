package pe.edu.upc.superherocompose.repositories

import android.util.Log
import pe.edu.upc.superherocompose.factories.HeroServiceFactory
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.model.data.HeroWrapper
import pe.edu.upc.superherocompose.model.remote.HeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepository(private val heroService: HeroService = HeroServiceFactory.getHeroService()) {

    fun getHeroes(name: String, callback: (List<Hero>) -> Unit) {
        val getHeroes = heroService.getHeroes(name)

        getHeroes.enqueue(object : Callback<HeroWrapper> {
            override fun onResponse(call: Call<HeroWrapper>, response: Response<HeroWrapper>) {
                if (response.isSuccessful) {
                    callback(response.body()?.heroes ?: emptyList())
                }
            }

            override fun onFailure(call: Call<HeroWrapper>, t: Throwable) {
                t.message?.let {
                    Log.d("HeroRepository", it)
                }
            }
        })
    }

    fun getHeroById(id: String, callback: (Hero) -> Unit) {
        val getHeroById = heroService.getHeroById(id = id)

        getHeroById.enqueue(object : Callback<Hero> {
            override fun onResponse(call: Call<Hero>, response: Response<Hero>) {
                if (response.isSuccessful) {
                    callback(response.body() as Hero)
                }
            }

            override fun onFailure(call: Call<Hero>, t: Throwable) {
                t.message?.let {
                    Log.d("HeroRepository", it)
                }
            }

        })
    }
}