package mx.edu.utez.axelSA.ui.screens.calculadora

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CalculadoraViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Calculadora") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar al menú")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Pantalla donde se ve el número
            Text(
                text = viewModel.pantalla,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.End,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .wrapContentHeight(Alignment.Bottom)
            )

            // Fila 1: 7 8 9 ÷
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.onBoton("7") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("7")
                }
                Button(
                    onClick = { viewModel.onBoton("8") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("8")
                }
                Button(
                    onClick = { viewModel.onBoton("9") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("9")
                }
                Button(
                    onClick = { viewModel.onBoton("÷") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("÷")
                }
            }

            // Fila 2: 4 5 6 ×
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.onBoton("4") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("4")
                }
                Button(
                    onClick = { viewModel.onBoton("5") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("5")
                }
                Button(
                    onClick = { viewModel.onBoton("6") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("6")
                }
                Button(
                    onClick = { viewModel.onBoton("×") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("×")
                }
            }

            // Fila 3: 1 2 3 -
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.onBoton("1") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("1")
                }
                Button(
                    onClick = { viewModel.onBoton("2") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("2")
                }
                Button(
                    onClick = { viewModel.onBoton("3") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("3")
                }
                Button(
                    onClick = { viewModel.onBoton("-") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("-")
                }
            }

            // Fila 4: C 0 = +
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.onBoton("C") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("C")
                }
                Button(
                    onClick = { viewModel.onBoton("0") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("0")
                }
                Button(
                    onClick = { viewModel.onBoton("=") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("=")
                }
                Button(
                    onClick = { viewModel.onBoton("+") },
                    modifier = Modifier.weight(1f).aspectRatio(1f)
                ) {
                    Text("+")
                }
            }
        }
    }
}
