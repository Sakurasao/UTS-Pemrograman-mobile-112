package com.sakurasao.uts_hanif_112

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { AppNavigation() }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onDetail = { navController.navigate("detail/42") }
            )
        }
        composable("detail/{id}") { entry ->
            val id = entry.arguments?.getString("id") ?: "-"
            DetailScreen(id = id)
        }
    }
}

@Composable
fun HomeScreen(onDetail: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Halaman Home")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onDetail) { Text("Detail") }
    }
}

@Composable
fun DetailScreen(id: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Halaman Detail, id = $id")
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    MaterialTheme { AppNavigation() }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MaterialTheme { DetailScreen(id = "42") }
}
