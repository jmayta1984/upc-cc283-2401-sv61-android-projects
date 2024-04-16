package pe.edu.upc.superherocompose.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.ui.herodetails.HeroDetails
import pe.edu.upc.superherocompose.ui.heroessearch.HeroesSearch

@Composable
fun Home() {
    val navController = rememberNavController()

    val heroes = remember {
        mutableStateOf(emptyList<Hero>())
    }

    val search = remember {
        mutableStateOf("")
    }

    NavHost(navController = navController, startDestination = Routes.HeroesSearch.route) {
        composable(Routes.HeroesSearch.route) {
            HeroesSearch (search,heroes){
                navController.navigate("${Routes.HeroDetails.route}/$it")
            }
        }
        composable(
            Routes.HeroDetails.routeWithArgument,
            arguments = listOf(navArgument(Routes.HeroDetails.argument) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString(Routes.HeroDetails.argument) as String
            HeroDetails(id)
        }
    }
}

sealed class Routes(val route: String) {
    object HeroesSearch : Routes("HeroesSearch")
    object HeroDetails : Routes("HeroDetails") {
        const val routeWithArgument = "HeroDetails/{id}"
        const val argument = "id"
    }
}