package mx.edu.utez.axelSA.ui.screens.mejoresamigos


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp


@Composable
fun ItemTarjeta(
    item: MejorAmigo,
    onClick: () -> Unit
){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable{onClick()},
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.nombre,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${item.edad}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = item.cumple,
                    style = MaterialTheme.typography.titleMedium
                )


            }
            Icon(
                imageVector = if (item.esAmigo) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (item.esAmigo) "Mejor amigo" else "No es mejor amigo",
                tint = if (item.esAmigo) Color.Red else Color.Gray,
                modifier = Modifier.size(28.dp)
            )
        }
    }

}
