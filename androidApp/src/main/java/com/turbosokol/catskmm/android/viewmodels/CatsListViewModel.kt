package com.turbosokol.catskmm.android.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.turbosokol.catskmm.data.CatsModel
import com.turbosokol.catskmm.data.network.KtorClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatsListViewModel: ViewModel() {
     val catsList: MutableState<List<CatsModel>> = mutableStateOf(listOf())
//    val catsList: State<List<CatsModel>> get() = _catsList

    fun fetchList() {
        KtorClient().fetchListOfCats {
            CoroutineScope(Dispatchers.Main).launch {
                catsList.value = it
            }
        }
    }

}