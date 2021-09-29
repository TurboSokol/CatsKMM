package com.turbosokol.catskmm.data

import kotlinx.serialization.Serializable

@Serializable
data class CatsModel(
    val id: String? = null,
    val created_at: String? = null,
    val tags: List<String?>? = null
)

