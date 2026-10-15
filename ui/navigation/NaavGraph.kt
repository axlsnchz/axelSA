package mx.edu.utez.axelSA.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utez.axelSA.ui.screens.calculadora.CalculadoraScreen
import mx.edu.utez.axelSA.ui.screens.carrusel.CarruselScreen
import mx.edu.utez.axelSA.ui.screens.conversor.ConversorScreen
import mx.edu.utez.axelSA.ui.screens.mejoresamigos.MejoramigoScreen
import mx.edu.utez.axelSA.ui.screens.menu.MenuScreen
import mx.edu.utez.axelSA.ui.screens.propinas.PropinasScreen
import mx.edu.utez.axelSA.ui.screens.gato.GatoScreen

// Definición de las rutas de navegación
sealed class Route(val path: String) {
    object Menu : Route("menu")
    object Conversor : Route("conversor")
    object Propinas : Route("propinas")
    object Calculadora : Route("calculadora")
    object Carrusel : Route("carrusel")
    object Mejoresamigos : Route("mejoresamigos")
    object Gato : Route("gato")


}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Menu.path,
        modifier = modifier
    ) {
        // 1. Pantalla Menú Principal
        composable(Route.Menu.path) {
            MenuScreen(
                onNavigateToConversor = { navController.navigate(Route.Conversor.path) },
                onNavigateToPropinas = { navController.navigate(Route.Propinas.path) },
                onNavigateToCalculadora = { navController.navigate(Route.Calculadora.path) },
                onNavigateToCarrusel = {navController.navigate(Route.Carrusel.path)},
                onNavigateToMejoresamigos = {navController.navigate(Route.Mejoresamigos.path)},
                onNavigateToGato = {navController.navigate(Route.Gato.path)}


            )
        }

        // 2. Pantalla Conversor de Divisas
        composable(Route.Conversor.path) {
            ConversorScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        // 3. Pantalla Calculadora de Propinas
        composable(Route.Propinas.path) {
            PropinasScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Route.Calculadora.path) {
            CalculadoraScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Route.Carrusel.path) {
            CarruselScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Route.Gato.path) {
            GatoScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Route.Mejoresamigos.path) {
            MejoramigoScreen()
        }
    }
}