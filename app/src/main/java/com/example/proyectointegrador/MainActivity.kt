package com.example.proyectointegrador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.compose.ui.unit.dp
import com.example.proyectointegrador.ui.theme.ProyectoIntegradorTheme
import com.example.proyectointegrador.view.MonitoreoTanques
import com.example.proyectointegrador.view.SistemaFiltrado
import com.example.proyectointegrador.view.ControlRemoto
import com.example.proyectointegrador.view.MantenimientoView
import com.example.proyectointegrador.view.ConfiguracionView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProyectoIntegradorTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf("tanques", "filtrado", "control", "mantenimiento", "config")

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            when (screen) {
                                "tanques" -> Icon(Icons.Default.Water, contentDescription = null)
                                "filtrado" -> Icon(Icons.Default.FilterAlt, contentDescription = null)
                                "control" -> Icon(Icons.Default.Power, contentDescription = null)
                                "mantenimiento" -> Icon(Icons.Default.Build, contentDescription = null)
                                "config" -> Icon(Icons.Default.Settings, contentDescription = null)
                            }
                        },
                        label = { Text(screen.replaceFirstChar { it.uppercaseChar() }) },
                        selected = navController.currentBackStackEntryAsState().value?.destination?.route == screen,
                        onClick = {
                            navController.navigate(screen) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "tanques",
            modifier = Modifier.padding(padding)
        ) {
            composable("tanques") { MonitoreoTanques() }
            composable("filtrado") { SistemaFiltrado() }
            composable("control") { ControlRemoto() }
            composable("mantenimiento") { MantenimientoView() }
            composable("config") { ConfiguracionView() }
        }
    }
}
