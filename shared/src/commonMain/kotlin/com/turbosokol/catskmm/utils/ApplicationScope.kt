package com.turbosokol.catskmm.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

val applicationScope = CoroutineScope(expectDispatcher + Job())