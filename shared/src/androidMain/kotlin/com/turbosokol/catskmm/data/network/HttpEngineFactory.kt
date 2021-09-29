package com.turbosokol.catskmm.data.network

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

actual class HttpEngineFactory {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = OkHttp
}