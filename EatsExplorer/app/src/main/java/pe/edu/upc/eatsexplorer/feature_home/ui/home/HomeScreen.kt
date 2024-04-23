package pe.edu.upc.eatsexplorer.feature_home.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.eatsexplorer.feature_auth.ui.signin.SignInScreen
import pe.edu.upc.eatsexplorer.feature_auth.ui.signup.SignUpScreen

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SignIn") {

        composable("SignIn") {
            SignInScreen {
                navController.navigate("SignUp")
            }
        }

        composable("SignUp") {
            SignUpScreen()
        }
    }
}