package com.turbosokol.catskmm.data.network

import com.turbosokol.catskmm.data.CatsModel
import com.turbosokol.catskmm.utils.applicationScope
import com.turbosokol.catskmm.utils.expectDispatcher
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class KtorClient {


    val client = HttpClient(HttpEngineFactory().createEngine()) {
        install(feature = JsonFeature) {
            serializer = KotlinxSerializer()

        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
    }

    private val myUrl = Url("https://cataas.com/api/cats")

    fun fetchListOfCats(callback: (List<CatsModel>) -> Unit) {
        applicationScope.launch(expectDispatcher) {
            val myResponse: List<CatsModel> = client.get(url = myUrl)

            callback(myResponse)
        }
    }
}