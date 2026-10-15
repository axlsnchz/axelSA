package mx.edu.utez.axelSA.ui.screens.mejoresamigos

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.map

data class MejorAmigo (
    val id: Int,
    val nombre: String,
    val edad: Int,
    val cumple: String,
    val esAmigo: Boolean
)


class MejoresamigosViewModel : ViewModel(){
    val amigo1 = MejorAmigo(1, "irving", 18, "01/01/2007", true)
    val amigo2 = MejorAmigo(2, "luis", 18, "01/01/2007", true)
    val amigo3 = MejorAmigo(3, "Cristian",18, "01/01/2007", true)
    val amigo4 = MejorAmigo(3, "Chavez", 18, "01/01/2007", true)
    val amigo5 = MejorAmigo(3, "gerardo", 18, "01/01/2007", true)
    val lista = listOf(amigo1,amigo2,amigo3,amigo4,amigo5)

    //Estado interno
    private val _elementos = MutableStateFlow<List<MejorAmigo>>(emptyList())
    //Estado publico
    val elementos: StateFlow<List<MejorAmigo>> = _elementos.asStateFlow()

    init {
        val amigo1 = MejorAmigo(0, "irving", 19, "14 de Agosto", true)
        val amigo2 = MejorAmigo(1, "luis", 19, "22 de Junio", true)
        val amigo3 = MejorAmigo(2, "Cristian",19, "26 de Marzo", true)
        val amigo4 = MejorAmigo(3, "Chavez", 19, "26 de Septiembre", true)
        val amigo5 = MejorAmigo(4, "gerardo", 19, "5 de Enero", true)
        _elementos.value = listOf(amigo1,amigo2,amigo3,amigo4,amigo5)
    }

    fun actualizarAmigo(id: Int){
        _elementos.update { listaActual ->
            listaActual.map {
                    item ->
                if (item.id == id){
                    item.copy(esAmigo =  !item.esAmigo)
                }else{
                    item
                }

            }

        }
    }


}