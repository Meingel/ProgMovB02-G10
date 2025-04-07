package com.example.proyectopoli.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.proyectopoli.screens.fragments.content.BotonesFragment
import com.example.proyectopoli.screens.fragments.content.FotosFragment
import com.example.proyectopoli.screens.fragments.content.PerfilFragment
import com.example.proyectopoli.screens.fragments.content.VideosFragment
import com.example.proyectopoli.screens.fragments.content.WebFragment

@Composable
fun ContentNavigation(
    selectedOption: String,
    navController: NavController,
    onBack: () -> Unit // ← AGREGA ESTE PARÁMETRO
) {
    when (selectedOption) {
        "perfil" -> PerfilFragment()
        "fotos" -> FotosFragment()
        "videos" -> VideosFragment()
        "web" -> WebFragment()
        "Botones" -> BotonesFragment(navController = navController, onBack = onBack) // ← PASA onBack
        else -> PerfilFragment()
    }
}
