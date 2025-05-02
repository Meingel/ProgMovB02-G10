package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.clickable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilFragment(navController: NavController, onBack: () -> Unit) {
    var showEstudiosDialog by remember { mutableStateOf(false) }
    var showTareasDialog by remember { mutableStateOf(false) }
    var showStatsDialog by remember { mutableStateOf(false) }

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
                        text = "Información de usuario",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2C2C2C))
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // --- Info de usuario ---
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = CircleShape,
                    color = Color.Gray,
                    modifier = Modifier.size(64.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Perfil",
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("Yaky Agudelo Agudelo", color = Color.White)
                    Text("C.C 123456", color = Color.White)
                    Text("Estudiante de Ingeniería de Software", color = Color.White, fontSize = 13.sp)
                }
            }

            // --- Estadísticas ---
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    onClick = { showEstudiosDialog = true },
                    colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Estudios registrados", color = Color.White, fontSize = 20.sp)
                        Text("2", color = Color(0xFFFFD54F), fontSize = 20.sp)
                    }
                }

                Card(
                    onClick = { showStatsDialog = true },
                    colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 20.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Estadísticas", color = Color.White, fontSize = 20.sp)
                        Text("", color = Color.White, fontSize = 20.sp)
                        Text("2/10 tareas", color = Color(0xFFFFD54F), fontSize = 20.sp)
                    }
                }
            }

            // --- Tareas pendientes ---
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF3A3A3A), RoundedCornerShape(20.dp))
                    .padding(12.dp)
                    .clickable { showTareasDialog = true } // ← Clickable completo
            ) {
                Text("Tareas pendientes", color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(14.dp))
                listOf(
                    Triple("Estudiar", "Done", "14/03/2025"),
                    Triple("Leer libro", "Done", "14/03/2025"),
                    Triple("Hacer aseo", "Pending", "14/03/2025")
                ).forEach { (tarea, estado, fecha) ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(tarea, color = Color.White)
                        Text(
                            estado,
                            color = if (estado == "Done") Color(0xFF4CAF50) else Color(0xFFFFD54F)
                        )
                        Text(fecha, color = Color.White, fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text("3 / 10", color = Color(0xFFFFD54F), modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            // --- Productividad y Tiempo ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.DarkGray, RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Text("Productividad", color = Color.White)
                    Text("15 días", color = Color.White, fontWeight = FontWeight.Bold)
                    Text("Mes actual", color = Color.White, fontSize = 20.sp)
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFFFD54F), RoundedCornerShape(8.dp))
                        .padding(23.dp)
                ) {
                    Text("2 horas y 20 min", fontWeight = FontWeight.Bold)
                    Text("Mes actual", fontSize = 20.sp)
                }
            }
        }

        // --- Diálogo: Estudios registrados ---
        if (showEstudiosDialog) {
            AlertDialog(
                onDismissRequest = { showEstudiosDialog = false },
                confirmButton = {
                    TextButton(onClick = { showEstudiosDialog = false }) {
                        Text("Cerrar")
                    }
                },
                title = { Text("Estudios registrados") },
                text = {
                    Column {
                        Text("1. Introducción a Kotlin")
                        Text("2. Arquitectura MVVM")
                        Text("3. Jetpack Compose avanzado")
                    }
                }
            )
        }

        // --- Diálogo: Tareas pendientes ---
        if (showTareasDialog) {
            AlertDialog(
                onDismissRequest = { showTareasDialog = false },
                confirmButton = {
                    TextButton(onClick = { showTareasDialog = false }) {
                        Text("Cerrar")
                    }
                },
                title = { Text("Tareas pendientes") },
                text = {
                    Column {
                        Text("✔ Estudiar - 14/03/2025")
                        Text("✔ Leer libro - 14/03/2025")
                        Text("⏳ Hacer aseo - 14/03/2025")
                        Text("Total: 3 de 10 completadas")
                    }
                }
            )
        }

        // --- Diálogo: Estadísticas ---
        if (showStatsDialog) {
            AlertDialog(
                onDismissRequest = { showStatsDialog = false },
                confirmButton = {
                    TextButton(onClick = { showStatsDialog = false }) {
                        Text("Cerrar")
                    }
                },
                title = { Text("Estadísticas") },
                text = {
                    Column {
                        Text("Tareas completadas: 2")
                        Text("Tareas totales: 10")
                        Text("Progreso: 20%")
                        Text("Última actualización: 01/05/2025")
                    }
                }
            )
        }
    }
}
