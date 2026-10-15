package mx.edu.utez.axelSA.ui.screens.mejoresamigos

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MejoramigoScreen(
    viewModel: MejoresamigosViewModel = viewModel()
){
    val listaElementos by viewModel.elementos.collectAsStateWithLifecycle()
    Column(){
        Text(
            "Mis mejores amigos",
            style = MaterialTheme.typography.titleLarge
        )
        ListaContenido(
            elementos = listaElementos,
            onItemClick = { id -> viewModel.actualizarAmigo(id) }
        )
    }
}