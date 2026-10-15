package mx.edu.utez.axelSA.ui.screens.carrusel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mx.edu.utez.axelSA.R


class CarruselViewModel : ViewModel() {

    val lista: List<Int> = listOf(
        R.drawable.pollo1,
        R.drawable.pollo2,
        R.drawable.pollo3
        )
    var indiceActual by mutableStateOf(0)
        private set

    val imagenActual: Int
        get() = lista[indiceActual]

    fun adelante() {
        if (indiceActual < 2){
            indiceActual++
        }else{
            indiceActual = 0

        }
    }

    fun atras(){

        if (indiceActual > 0){
            indiceActual--

        }else{
            indiceActual = lista.size-1

        }


    }
}