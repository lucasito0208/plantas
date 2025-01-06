package com.plantas.garden

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.plantas.garden.config.RetrofitInstance
import com.plantas.garden.modelo.Plantas
import com.plantas.garden.ui.theme.GardenTheme
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GardenApp()
        }
    }
}


@Composable
fun GardenApp() {
    val plantas = remember { mutableStateListOf<Plantas>() }

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.api.getPlants()
            plantas.clear()
            plantas.addAll(response.plantas)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    ListaPlantas(plantas = plantas)
}

@Composable
fun ListaPlantas(plantas: List<Plantas>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(plantas) {
            planta ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(text = "ID: ${planta.id}")
                    Text(text = "Nombre: ${planta.nombre}")
                    Text(text = "Tipo: ${planta.tipo}")
                    AsyncImage(
                        model = planta.imagen.urlImagen,
                        contentDescription = "Imagen de ${planta.nombre}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GardenPreview() {
    GardenApp()
}