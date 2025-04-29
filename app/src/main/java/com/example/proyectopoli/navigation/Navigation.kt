package com.example.proyectopoli.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.proyectopoli.screens.fragments.content.BotonesFragment
import com.example.proyectopoli.screens.fragments.content.FotosFragment
import com.example.proyectopoli.screens.fragments.content.PerfilFragment
import com.example.proyectopoli.screens.fragments.content.VideosFragment
import com.example.proyectopoli.screens.fragments.content.WebFragment
import com.example.proyectopoli.screens.fragments.content.GestionarTareasScreen

@Composable
fun ContentNavigation(
    selectedOption: String,
    navController: NavController,
    onBack: () -> Unit,
) {
    when (selectedOption) {
        "Perfil" -> PerfilFragment(navController = navController, onBack = onBack)
        "Fotos" -> FotosFragment()
        "Videos" -> VideosFragment()
        "Web" -> WebFragment(navController = navController, onBack = onBack)
        "Botones" -> BotonesFragment(
            navController = navController,
            onBack = onBack,
            onOptionSelected = { newSelectedOption ->
                // Esto actualiza el valor de selectedOption en HomeScreen
                onBack()
            }
        )
        "Editar Tarea" -> GestionarTareasScreen()
        else -> PerfilFragment(navController = navController, onBack = onBack)
    }
}
