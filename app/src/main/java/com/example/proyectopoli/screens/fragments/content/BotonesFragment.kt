package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BotonesFragment(navController: NavController, onBack: () -> Unit) {
    val botonesConIconos = listOf(
        "Agendar Tarea" to Icons.Default.Add,
        "Editar Tarea" to Icons.Default.Edit,
        "Calendario" to Icons.Default.CalendarToday,
        "Equipos" to Icons.Default.Group,
        "Historial" to Icons.Default.History
    )

    Scaffold(
        topBar = {
            Surface(
                color = Color(0xFFFFD54F),
                shadowElevation = 4.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 5.dp)
                ) {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.Black
                        )
                    }
                    Text(
                        text = "Gestionar Tareas",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(48.dp))
                }
            }
        },
        content = { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                color = Color(0xFF2C2C2C) // Color de fondo oscuro
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 100.dp),
                        verticalArrangement = Arrangement.spacedBy(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        botonesConIconos.chunked(2).forEach { fila ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(28.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                fila.forEach { (texto, icono) ->
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .height(120.dp)
                                            .clickable { /* Acción aquí */ },
                                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFD54F)),
                                        shape = RoundedCornerShape(12.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(12.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Icon(
                                                imageVector = icono,
                                                contentDescription = texto,
                                                tint = Color(0xFF616161),
                                                modifier = Modifier.size(32.dp)
                                            )
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Text(
                                                text = texto,
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = Color.Black,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                }
                                if (fila.size == 1) {
                                    Spacer(modifier = Modifier.width(180.dp))
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(60.dp))
                    }
                }
            }
        }
    )
}
