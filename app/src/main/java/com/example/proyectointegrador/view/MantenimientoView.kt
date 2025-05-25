package com.example.proyectointegrador.view

import androidx.compose.material3.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MantenimientoView() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mantenimiento") }) }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).padding(16.dp)) {
            item {
                ListItem(
                    headlineContent = { Text("Revisión de filtros") },
                    supportingContent = { Text("Próxima: 28/06/2025") },
                    trailingContent = {
                        Icon(Icons.Filled.CalendarToday, contentDescription = null)
                    }
                )
                Divider()
            }
            item {
                ListItem(
                    headlineContent = { Text("Limpieza de tanque") },
                    supportingContent = { Text("Última vez: 01/05/2025") },
                    trailingContent = {
                        Icon(Icons.Filled.Build, contentDescription = null)
                    }
                )
            }
        }
    }
}
