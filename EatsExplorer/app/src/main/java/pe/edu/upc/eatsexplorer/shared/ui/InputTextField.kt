package pe.edu.upc.eatsexplorer.shared.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun InputTextField(input: MutableState<String>, placeholder: String) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = placeholder)
        },
        value = input.value, onValueChange = {
            input.value = it
        })
}