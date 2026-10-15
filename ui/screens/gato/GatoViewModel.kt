package mx.edu.utez.axelSA.ui.screens.gato

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GatoViewModel : ViewModel() {

    val casillas = mutableStateListOf("", "", "", "", "", "", "", "", "")

    var mensaje by mutableStateOf("Turno de X")
        private set

    private var turno = "X"
    private var juegoTerminado = false

    fun onCasilla(posicion: Int) {
        if (juegoTerminado == true) {
            return
        }

        if (casillas[posicion] != "") {
            return
        }

        casillas[posicion] = turno

        if (hayGanador() == true) {
            mensaje = "¡Ganó " + turno + "!"
            juegoTerminado = true
        } else if (tableroLleno() == true) {
            mensaje = "¡Empate!"
            juegoTerminado = true
        } else {
            if (turno == "X") {
                turno = "O"
            } else {
                turno = "X"
            }
            mensaje = "Turno de " + turno
        }
    }

    private fun hayGanador(): Boolean {
        // Filas
        if (tresIguales(0, 1, 2)) return true
        if (tresIguales(3, 4, 5)) return true
        if (tresIguales(6, 7, 8)) return true

        // Columnas
        if (tresIguales(0, 3, 6)) return true
        if (tresIguales(1, 4, 7)) return true
        if (tresIguales(2, 5, 8)) return true

        // Diagonales
        if (tresIguales(0, 4, 8)) return true
        if (tresIguales(2, 4, 6)) return true

        return false
    }

    private fun tresIguales(a: Int, b: Int, c: Int): Boolean {
        if (casillas[a] != "" && casillas[a] == casillas[b] && casillas[b] == casillas[c]) {
            return true
        }
        return false
    }

    private fun tableroLleno(): Boolean {
        if (casillas.contains("")) {
            return false
        }
        return true
    }

    fun reiniciar() {
        for (i in 0..8) {
            casillas[i] = ""
        }
        turno = "X"
        juegoTerminado = false
        mensaje = "Turno de X"
    }
}