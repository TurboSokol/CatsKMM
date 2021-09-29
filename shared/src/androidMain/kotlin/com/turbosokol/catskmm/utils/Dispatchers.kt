package com.turbosokol.catskmm.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val expectDispatcher: CoroutineDispatcher = Dispatchers.IO
