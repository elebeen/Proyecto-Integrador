package com.example.proyectointegrador.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguracionView() {
    var notificaciones by remember { mutableStateOf(true) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Configuración") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            // Item con switch personalizado (reemplazo de SwitchListItem)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Notificaciones")
                Switch(
                    checked = notificaciones,
                    onCheckedChange = { notificaciones = it }
                )
            }

            Divider()

            ListItem(
                headlineContent = { Text("Unidad de medida") },
                supportingContent = { Text("Litros") },
                trailingContent = {
                    Icon(Icons.Filled.ChevronRight, contentDescription = null)
                }
            )

            ListItem(
                headlineContent = { Text("Idioma") },
                supportingContent = { Text("Español") },
                trailingContent = {
                    Icon(Icons.Filled.ChevronRight, contentDescription = null)
                }
            )
        }
    }
}
