package com.example.proyectopoli.screens.fragments.content // Nombre del paquete, ajusta si moviste el archivo

// Importaciones necesarias para diseño y comportamiento con Jetpack Compose
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.automirrored.filled.ArrowBack // Para que la flecha se adapte al idioma

@OptIn(ExperimentalMaterial3Api::class) // Permite usar componentes experimentales como TopAppBar
@Composable
fun BotonesFragment() {
    // Scaffold es un layout base que contiene elementos como barra superior
    Scaffold(
        topBar = {
            // Barra superior con título centrado
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Gestionar Tareas", // Título que se muestra
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    // Botón con ícono de volver (aún sin funcionalidad)
                    IconButton(onClick = { /* acción para volver */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Flecha adaptativa (LTR o RTL)
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        },
        content = { padding ->
            // Cuerpo de la pantalla con espaciado y alineación
            Column(
                modifier = Modifier
                    .fillMaxSize() // Ocupar todo el alto y ancho posible
                    .padding(padding) // Padding automático del Scaffold
                    .padding(16.dp), // Padding adicional
                verticalArrangement = Arrangement.spacedBy(16.dp), // Espacio entre tarjetas
                horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
            ) {
                // Lista de botones que se mostrarán como tarjetas
                listOf("Agendar Tarea", "Editar Tarea", "Calendario", "Equipos", "Historial").forEach { texto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth() // Ocupar todo el ancho
                            .clickable { /* acción según texto */ }, // Aún sin acción implementada
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0)), // Color gris claro
                        shape = RoundedCornerShape(12.dp) // Bordes redondeados
                    ) {
                        Box(
                            contentAlignment = Alignment.Center, // Centrar contenido dentro de la tarjeta
                            modifier = Modifier.padding(24.dp) // Padding interno
                        ) {
                            Text(
                                text = texto, // Texto de la tarjeta
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
        }
    )
}
