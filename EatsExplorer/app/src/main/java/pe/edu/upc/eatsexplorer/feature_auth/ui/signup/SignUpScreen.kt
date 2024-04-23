package pe.edu.upc.eatsexplorer.feature_auth.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.UserRequest
import pe.edu.upc.eatsexplorer.feature_auth.data.repository.AuthRepository
import pe.edu.upc.eatsexplorer.shared.ui.CustomButton
import pe.edu.upc.eatsexplorer.shared.ui.InputTextField
import pe.edu.upc.eatsexplorer.shared.ui.PasswordTextField

@Composable
fun SignUpScreen(authRepository: AuthRepository = AuthRepository(), navigateTo: () -> Unit) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            val firstName = remember {
                mutableStateOf("")
            }
            val lastName = remember {
                mutableStateOf("")
            }
            val username = remember {
                mutableStateOf("")
            }
            val password = remember {
                mutableStateOf("")
            }
            val confirmPassword = remember {
                mutableStateOf("")
            }
            InputTextField(input = firstName, placeholder = "First name")
            InputTextField(input = lastName, placeholder = "Last name")
            InputTextField(input = username, placeholder = "Username")
            PasswordTextField(input = password, placeholder = "Password")
            PasswordTextField(input = confirmPassword, placeholder = "Confirm password")
            CustomButton(text = "Sign up") {
                authRepository.signUp(
                    UserRequest(
                        username.value,
                        lastName.value,
                        firstName.value,
                        password.value
                    )
                ) {
                    navigateTo()
                }
            }
        }
    }
}