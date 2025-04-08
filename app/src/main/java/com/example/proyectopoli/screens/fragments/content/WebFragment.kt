package com.example.proyectopoli.screens.fragments.content

import androidx.compose.material.icons.filled.ArrowBack
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.material.icons.Icons
import androidx.navigation.NavController


@Composable
fun WebFragment(navController: NavController, onBack: () -> Unit) {
    // Estado para la URL ingresada
    var url by remember { mutableStateOf("https://www.google.com") }

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
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Cuadro de texto para ingresar la URL
                var textFieldValue by remember { mutableStateOf(TextFieldValue(url)) }
                BasicTextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(50.dp),
                    textStyle = LocalTextStyle.current.copy(color = Color.Black)
                )

                // Botón para cargar la página
                Button(
                    onClick = { url = textFieldValue.text },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Cargar Página")
                }

                // WebView para mostrar la página cargada
                AndroidView(factory = { context ->
                    WebView(context).apply {
                        webViewClient = WebViewClient()
                        loadUrl(url)
                    }
                }, modifier = Modifier.fillMaxSize())
            }
        }
    )
}
