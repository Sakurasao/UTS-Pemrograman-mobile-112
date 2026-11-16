package com.sakurasao.uts_hanif_112

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { DaftarTugas() }
        }
    }
}

data class Tugas(val judul: String, val tanggal: String)

@Composable
fun DaftarTugas() {
    val daftar = listOf(
        Tugas("Laporan Praktikum Compose", "20 Nov 2026"),
        Tugas("Quiz Navigation", "25 Nov 2026"),
        Tugas("Proposal Proyek Akhir", "30 Nov 2026")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(daftar) { tugas ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(tugas.judul, style = MaterialTheme.typography.titleMedium)
                        Text("Dikumpulkan: ${tugas.tanggal}")
                    }
                    Button(onClick = { /* aksi detail */ }) {
                        Text("Detail")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarTugasPreview() {
    MaterialTheme { DaftarTugas() }
}
