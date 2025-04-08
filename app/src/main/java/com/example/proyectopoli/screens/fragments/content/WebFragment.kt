package com.example.proyectopoli.screens.fragments.content

import androidx.compose.material.icons.filled.ArrowBack
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.material.icons.Icons
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebFragment(navController: NavController, onBack: () -> Unit) {
    // Estado para la URL actual y el texto en el cuadro de entrada
    var url by remember { mutableStateOf("https://www.google.com") }
    var textFieldValue by remember { mutableStateOf(url) }

    Scaffold(
        topBar = {
            Surface(
                color = Color(0xFFFFC107), // Amarillo vibrante como en tu app
                shadowElevation = 4.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.Black // Negro como en tu app
                        )
                    }
                    Text(
                        text = "Navegador Web",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black, // Texto negro
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Cuadro de texto para ingresar la URL
                TextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    label = { Text("Ingresa una URL") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color(0xFFFFC107),
                        unfocusedIndicatorColor = Color.Gray,
                        containerColor = Color.Transparent
                    )
                )


                // Botón para cargar la página
                Button(
                    onClick = {
                        // Validar y actualizar la URL
                        val processedUrl = if (textFieldValue.startsWith("http://") || textFieldValue.startsWith("https://")) {
                            textFieldValue
                        } else {
                            "https://$textFieldValue" // Agrega "https://" si falta
                        }
                        url = processedUrl
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFC107), // Fondo amarillo vibrante
                        contentColor = Color.Black // Texto negro
                    )
                ) {
                    Text("Cargar Página")
                }

                // WebView que carga la URL
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            webViewClient = WebViewClient()
                            settings.apply {
                                javaScriptEnabled = true // Habilitar JavaScript
                                domStorageEnabled = true // Almacenamiento DOM
                                cacheMode = WebSettings.LOAD_NO_CACHE // Evitar uso de caché
                            }
                        }
                    },
                    update = { webView ->
                        webView.loadUrl(url) // Cargar la URL actualizada
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    )
}
