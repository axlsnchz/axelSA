package mx.edu.utez.axelSA.ui.screens.mejoresamigos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ListaContenido(
    elementos: List<MejorAmigo>,
    onItemClick: (Int) -> Unit
){
    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        //foreach
        items(
            items = elementos,
            key = { item -> item.id}
        ){
            item ->
            ItemTarjeta(item = item, onClick = { onItemClick((item.id)) })
        }
    }
}