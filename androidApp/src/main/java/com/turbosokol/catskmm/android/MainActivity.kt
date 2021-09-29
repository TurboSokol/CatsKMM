package com.turbosokol.catskmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.turbosokol.catskmm.android.ui.theme.CatsKMMTheme
import com.turbosokol.catskmm.android.ui.widgets.DetailScreen
import com.turbosokol.catskmm.android.ui.widgets.MainScreen
import com.turbosokol.catskmm.android.ui.widgets.Screens
import com.turbosokol.catskmm.android.viewmodels.CatsListViewModel
import com.turbosokol.catskmm.data.CatsModel
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {


    private val myUiScope = CoroutineScope(Dispatchers.Main + Job())

    private val catsListViewModel: CatsListViewModel by viewModels()
   // private var catsList: List<CatsModel> = emptyList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setList()

        myUiScope.launch {
            setContent {

                val catsList = catsListViewModel.catsList.value

                CatsKMMTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {

                        if (catsList.isEmpty()) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                CircularProgressIndicator(color = MaterialTheme.colors.secondary)
                            }
                        }

                        if (catsList.isNotEmpty()) {
                            ComposeNavigate(catsList)
                        }

                    }
                }
            }
        }

    }

    private fun setList() {
        catsListViewModel.fetchList()
    }

    @Composable
    fun ComposeNavigate(catsList: List<CatsModel>) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
            composable(route = Screens.MainScreen.route) {
                MainScreen(navController = navController, items = catsList)
            }
            composable(route = Screens.DetailScreen.route
//                arguments = listOf(
//                navArgument("arg"){
//                    type = NavType.StringType
//                    defaultValue = "default value"
//                    nullable = true
//                }
            //)
            ) {
                it.arguments?.getString("arg").let {
                    DetailScreen(id = it)
                }

            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatsKMMTheme {

    }
}