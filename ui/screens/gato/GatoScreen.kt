package mx.edu.utez.axelSA.ui.screens.gato

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GatoScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: GatoViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Gato") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar al menú")
                    }
                },

            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mensaje de turno o ganador
            Text(
                text = viewModel.mensaje,
                fontSize = 28.sp
            )

            // Fila 1: casillas 0, 1, 2
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.onCasilla(0) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[0], fontSize = 40.sp)
                }
                Button(
                    onClick = { viewModel.onCasilla(1) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[1], fontSize = 40.sp)
                }
                Button(
                    onClick = { viewModel.onCasilla(2) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[2], fontSize = 40.sp)
                }
            }

            // Fila 2: casillas 3, 4, 5
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.onCasilla(3) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[3], fontSize = 40.sp)
                }
                Button(
                    onClick = { viewModel.onCasilla(4) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[4], fontSize = 40.sp)
                }
                Button(
                    onClick = { viewModel.onCasilla(5) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[5], fontSize = 40.sp)
                }
            }

            // Fila 3: casillas 6, 7, 8
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.onCasilla(6) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[6], fontSize = 40.sp)
                }
                Button(
                    onClick = { viewModel.onCasilla(7) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[7], fontSize = 40.sp)
                }
                Button(
                    onClick = { viewModel.onCasilla(8) },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text(viewModel.casillas[8], fontSize = 40.sp)
                }
            }

            // Botón para jugar otra vez
            Button(
                onClick = { viewModel.reiniciar() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reiniciar", fontSize = 20.sp)
            }
        }
    }
}