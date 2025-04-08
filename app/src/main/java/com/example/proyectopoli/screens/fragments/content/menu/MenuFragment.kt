package com.example.proyectopoli.screens.fragments.content.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.model.MenuItem
import androidx.compose.foundation.clickable


@Composable
fun MenuFragment(
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val menuItems = listOf(
        MenuItem(id = "Perfil", title = "Perfil", icon = Icons.Default.Person),
        MenuItem(id = "Fotos", title = "Fotos", icon = Icons.Default.Image),
        MenuItem(id = "Videos", title = "Videos", icon = Icons.Default.Videocam),
        MenuItem(id = "Web", title = "Web", icon = Icons.Default.Language),
        MenuItem(id = "Botones", title = "Botones", icon = Icons.Default.AddCircle)
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(225.dp)
            .background(Color(0xFFFFD54F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            items(menuItems) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { onOptionSelected(item.id) }
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = Color.Black,
                        modifier = Modifier.size(55.dp) // Más grande
                    )
                    Text(
                        text = item.title,
                        color = Color.Black, // Cambiado a negro
                        fontSize = 20.sp, // Tamaño un poquito mayor
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}
