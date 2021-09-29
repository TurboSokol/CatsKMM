package com.turbosokol.catskmm.android.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import coil.Coil
import coil.ImageLoader
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.util.CoilUtils
import com.turbosokol.catskmm.android.R
import com.turbosokol.catskmm.android.androidUtil.DEFAULT_IMAGE_PLACEHOLDER
import com.turbosokol.catskmm.android.ui.theme.CatsKMMTheme

@Composable
fun DetailScreen(id: String?) {

    val imageUrl = "https://cataas.com/cat?filter=$id"

    Card {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = imageUrl, builder = {
                    placeholder(DEFAULT_IMAGE_PLACEHOLDER)
                }),
                contentDescription = stringResource(R.string.kitty_image_descrition),
                modifier = Modifier.size(1024.dp)
            )
        }


        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Button(
                onClick = {savePictureToGallery()},
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = rememberImagePainter(data = R.drawable.ic_baseline_save_alt_24),
                    contentDescription = ""
                )
            }
        }
    }
}

fun savePictureToGallery() {
    TODO("Not yet implemented")
}



