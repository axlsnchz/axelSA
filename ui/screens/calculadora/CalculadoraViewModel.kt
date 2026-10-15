package mx.edu.utez.axelSA.ui.screens.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculadoraViewModel : ViewModel() {

    // 1. Lo que se muestra en la pantalla
    var pantalla by mutableStateOf("0")
        private set

    // 2. Variables para recordar la operación
    private var primerNumero = 0.0
    private var operacion = ""
    private var nuevoNumero = true

    // 3. Función que llaman todos los botones
    fun onBoton(boton: String) {
        if (boton == "C") {
            limpiar()
        } else if (boton == "=") {
            calcular()
        } else if (boton == "+" || boton == "-" || boton == "×" || boton == "÷") {
            elegirOperacion(boton)
        } else {
            escribirDigito(boton)
        }
    }

    // 4. Cuando presionas un número
    private fun escribirDigito(digito: String) {
        if (nuevoNumero == true || pantalla == "0" || pantalla == "Error") {
            pantalla = digito
        } else {
            pantalla = pantalla + digito
        }
        nuevoNumero = false
    }

    // 5. Cuando presionas + - × ÷
    private fun elegirOperacion(op: String) {
        if (pantalla == "Error") {
            return
        }

        if (operacion != "") {
            return
        }

        primerNumero = pantalla.toDouble()
        operacion = op
        nuevoNumero = true
    }

    // 6. Cuando presionas =
    private fun calcular() {
        if (operacion == "" || pantalla == "Error") {
            return
        }

        val segundoNumero = pantalla.toDouble()
        var resultado = 0.0

        if (operacion == "÷" && segundoNumero == 0.0) {
            pantalla = "Error"
        } else {
            if (operacion == "+") {
                resultado = primerNumero + segundoNumero
            } else if (operacion == "-") {
                resultado = primerNumero - segundoNumero
            } else if (operacion == "×") {
                resultado = primerNumero * segundoNumero
            } else if (operacion == "÷") {
                resultado = primerNumero / segundoNumero
            }
            pantalla = formatear(resultado)
        }

        primerNumero = 0.0
        operacion = ""
        nuevoNumero = true
    }

    // 7. Cuando presionas C
    private fun limpiar() {
        pantalla = "0"
        primerNumero = 0.0
        operacion = ""
        nuevoNumero = true
    }

    // 8. Quitar el ".0" a los números enteros
    private fun formatear(numero: Double): String {
        var texto = numero.toString()
        if (texto.endsWith(".0")) {
            texto = texto.substring(0, texto.length - 2)
        }
        return texto
    }
}