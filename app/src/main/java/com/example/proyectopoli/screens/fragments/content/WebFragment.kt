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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.background


@Composable
fun WebFragment(navController: NavController, onBack: () -> Unit) {
    // Estado para la URL actual y el texto en el cuadro de entrada
    var url by remember { mutableStateOf("https://www.google.com") }
    var textFieldValue by remember { mutableStateOf(url) }

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
                        .padding(8.dp)
                ) {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.Black
                        )
                    }
                    Text(
                        text = "Navegador Web",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
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
                    .background(Color(0xFF2C2C2C)) // Fondo oscuro
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
                    singleLine = true
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
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cargar Página")
                }

                // WebView que carga la URL

                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            webViewClient = WebViewClient()
                            settings.apply {
                                javaScriptEnabled = true
                                domStorageEnabled = true
                                cacheMode = WebSettings.LOAD_NO_CACHE
                            }
                        }
                    },
                    update = { webView ->
                        webView.loadUrl(url)
                    },
                    modifier = Modifier.fillMaxSize()
                )

            }
        }
    )
}
