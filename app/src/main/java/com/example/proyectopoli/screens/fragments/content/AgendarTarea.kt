package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GestionarTareasScreen() {
 Scaffold(
  topBar = {
   TopAppBar(
    title = { Text("Gestionar Tareas") },
    colors = TopAppBarDefaults.topAppBarColors(
     containerColor = Color(0xFFFFD54F)
    )
   )
  }
 ) { innerPadding ->
  Column(
   modifier = Modifier
    .fillMaxSize()
    .padding(innerPadding)
    .padding(16.dp),
   verticalArrangement = Arrangement.Top,
   horizontalAlignment = Alignment.CenterHorizontally
  ) {
   Text(
    text = "Aquí podrás editar, eliminar o ver tareas existentes.",
    fontSize = 18.sp,
    fontWeight = FontWeight.Medium
   )
  }
 }
}
