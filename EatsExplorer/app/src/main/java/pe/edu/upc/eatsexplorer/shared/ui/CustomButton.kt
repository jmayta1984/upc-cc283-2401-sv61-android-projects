package pe.edu.upc.eatsexplorer.shared.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomButton(text: String){
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}