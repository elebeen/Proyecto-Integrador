package com.example.proyectointegrador.view

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.AccessTime  // En vez de Timer
import androidx.compose.material.icons.filled.Water      // En vez de WaterDrop
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SistemaFiltrado() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Sistema de Filtrado") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            ListItem(
                headlineContent = { Text("Estado del filtro: Operativo") },
                leadingContent = {
                    Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Color.Green)
                }
            )
            Divider()
            ListItem(
                headlineContent = { Text("Calidad del agua: Alta") },
                leadingContent = {
                    Icon(Icons.Filled.Water, contentDescription = null)
                }
            )
            Divider()
            ListItem(
                headlineContent = { Text("Tiempo restante: 2 horas") },
                leadingContent = {
                    Icon(Icons.Filled.AccessTime, contentDescription = null)
                }
            )
        }
    }
}
