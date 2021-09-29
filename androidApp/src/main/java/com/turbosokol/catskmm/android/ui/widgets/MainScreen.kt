package com.turbosokol.catskmm.android.ui.widgets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.turbosokol.catskmm.data.CatsModel

@Composable
fun MainScreen(
    navController: NavController,
    items: List<CatsModel>
) {
    //VISUAL MATERIAL STRUCTURE
    Scaffold(content = {
        LazyColumn() {
            itemsIndexed(items = items) { index, item ->
                CatCard(index, item, onClick = {
                        navController.navigate(Screens.DetailScreen.createRoute(item.id))
                })
            }
        }
    })
}