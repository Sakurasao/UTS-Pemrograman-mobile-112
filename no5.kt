package com.sakurasao.uts_hanif_112

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { JadwalScreen() }
        }
    }
}

data class Jadwal(val mataKuliah: String, val hari: String, val jam: String)

@Composable
fun JadwalScreen() {
    val jadwal = listOf(
        Jadwal("Pemrograman Mobile", "Senin", "08:00"),
        Jadwal("Basis Data", "Selasa", "10:00"),
        Jadwal("Jaringan Komputer", "Senin", "13:00"),
        Jadwal("Algoritma", "Rabu", "09:00")
    )

    val jadwalHariIni = jadwal
        .filter { it.hari == "Senin" }
        .map { "${it.jam} - ${it.mataKuliah}" }

    Column(Modifier.padding(16.dp)) {
        Text("Jadwal Hari Ini (Senin)", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        jadwalHariIni.forEach { Text(it) }
    }
}

@Preview(showBackground = true)
@Composable
fun JadwalScreenPreview() {
    MaterialTheme { JadwalScreen() }
}
