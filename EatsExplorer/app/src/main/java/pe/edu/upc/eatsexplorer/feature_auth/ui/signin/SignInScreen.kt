package pe.edu.upc.eatsexplorer.feature_auth.ui.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.eatsexplorer.shared.ui.CustomButton
import pe.edu.upc.eatsexplorer.shared.ui.InputTextField
import pe.edu.upc.eatsexplorer.shared.ui.PasswordTextField
import pe.edu.upc.eatsexplorer.ui.theme.EatsExplorerTheme

@Composable
fun SignInScreen(navigateTo: () -> Unit) {
    Scaffold { paddingValues ->
        val username = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            InputTextField(input = username, placeholder = "Username")
            PasswordTextField(input = password, placeholder = "Password")
            CustomButton(text = "Sign in") {}
            CustomButton(text = "Sign up", navigateTo)

        }
    }
}