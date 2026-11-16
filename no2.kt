package com.sakurasao.uts_hanif_112

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { ParentScreen() }
        }
    }
}

@Composable
fun ParentScreen() {
    var teks by remember { mutableStateOf("") } // state ada di parent

    Column(Modifier.padding(16.dp)) {
        InputNama(
            value = teks,
            onValueChange = { teks = it }
        )
        Spacer(Modifier.height(8.dp))
        Text("Halo, $teks")
    }
}

@Composable
fun InputNama(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Nama") }
    )
}

@Preview(showBackground = true)
@Composable
fun ParentScreenPreview() {
    MaterialTheme { ParentScreen() }
}
