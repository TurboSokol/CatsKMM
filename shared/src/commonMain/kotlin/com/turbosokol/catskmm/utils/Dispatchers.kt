package com.turbosokol.catskmm.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
expect val expectDispatcher: CoroutineDispatcher
