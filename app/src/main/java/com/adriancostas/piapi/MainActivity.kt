package com.adriancostas.piapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriancostas.piapi.ui.theme.PiaPiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiaPiTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Piapi") }
            )
        }
    ) { padding ->
        Content(Modifier.padding(padding))
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    // Lista de datos de ejemplo
    val data = listOf("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Texto descriptivo
        Text(
            text = "En Piapi podrás ayudar al resto de la humanidad con tu granito de arena.",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Imagen
        Image(
            painter = painterResource(id = R.drawable.ayuda),
            contentDescription = "Imagen de ayuda",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
        )

        // Lista de elementos
        LazyColumn {
            items(data) { item ->
                ListItem(item)
            }
        }
    }
}

@Composable
fun ListItem(item: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = item,
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    PiaPiTheme {
        MainScreen()
    }
}