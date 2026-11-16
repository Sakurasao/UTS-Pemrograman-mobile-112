package com.sakurasao.uts_hanif_112

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { MenuUtamaScreen() }
        }
    }
}

@Composable
fun MenuUtamaScreen() {
    val context = LocalContext.current
    val menu = listOf("Profil", "Jadwal", "Nilai", "Tagihan")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Menu Akademik",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(menu) { nama ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clickable {
                            // callback sederhana
                            Toast.makeText(context, "Buka $nama", Toast.LENGTH_SHORT).show()
                        }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(nama, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuUtamaScreenPreview() {
    MaterialTheme { MenuUtamaScreen() }
}
