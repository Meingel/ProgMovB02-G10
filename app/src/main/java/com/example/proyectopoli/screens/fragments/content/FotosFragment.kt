@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.proyectopoli.screens.fragments.content

import com.example.proyectopoli.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FotosFragment() {
    var selectedImage by remember { mutableStateOf<Int>(R.drawable.futbol) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFC107))
                .padding(vertical = 12.dp)
        ) {
            Text(
                text = "FOTOS",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Imagen principal
        Image(
            painter = painterResource(id = selectedImage),
            contentDescription = "Imagen principal",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Texto descriptivo
        Text(
            text = "El fútbol: al jugar fútbol el cuerpo libera estrés y tensiones, " +
                    "por ello es importante practicar algún deporte en tu tiempo libre... ¡anímate!",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Miniaturas
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Thumbnail(R.drawable.thumb1) { selectedImage = R.drawable.thumb1 }
            }
            item {
                Thumbnail(R.drawable.thumb2) { selectedImage = R.drawable.thumb2 }
            }
            item {
                Thumbnail(R.drawable.thumb3) { selectedImage = R.drawable.thumb3 }
            }
            item {
                Thumbnail(R.drawable.thumb4) { selectedImage = R.drawable.thumb4 }
            }
        }

        // Flechas de navegación debajo de las miniaturas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { /* Anterior */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Anterior", tint = Color.White)
            }
            IconButton(onClick = { /* Siguiente */ }) {
                Icon(Icons.Filled.ArrowForward, contentDescription = "Siguiente", tint = Color.White)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Botones inferiores
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { /* Zoom in */ }) {
                Icon(Icons.Filled.ZoomIn, contentDescription = "Zoom In", tint = Color.White)
            }
            IconButton(onClick = { /* Zoom out */ }) {
                Icon(Icons.Filled.ZoomOut, contentDescription = "Zoom Out", tint = Color.White)
            }
            IconButton(onClick = { /* Compartir */ }) {
                Icon(Icons.Filled.Share, contentDescription = "Compartir", tint = Color.White)
            }
            IconButton(onClick = { /* Editar */ }) {
                Icon(Icons.Filled.Edit, contentDescription = "Editar", tint = Color.White)
            }
            IconButton(onClick = { /* Cámara */ }) {
                Icon(Icons.Filled.CameraAlt, contentDescription = "Cámara", tint = Color.White)
            }
            IconButton(onClick = { /* Grupo/Personas */ }) {
                Icon(Icons.Filled.Group, contentDescription = "Grupo", tint = Color.White)
            }
        }

        // Logos de redes sociales
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook_icon),
                contentDescription = "Facebook",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = R.drawable.instagram_icon),
                contentDescription = "Instagram",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = R.drawable.twitter_icon),
                contentDescription = "Twitter",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun Thumbnail(imageRes: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}
