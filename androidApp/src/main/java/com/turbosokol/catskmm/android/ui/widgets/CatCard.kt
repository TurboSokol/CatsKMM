package com.turbosokol.catskmm.android.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.R
import coil.compose.rememberImagePainter
import com.turbosokol.catskmm.android.androidUtil.DEFAULT_IMAGE_PLACEHOLDER
import com.turbosokol.catskmm.data.CatsModel

@Composable
fun CatCard(index:Int, cat: CatsModel, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(bottom = 6.dp, top = 6.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Row(modifier = Modifier.padding(4.dp)) {

            val myImageUrl = "https://cataas.com/cat?filter=${cat.id}"
            
                Image(painter = rememberImagePainter(data = myImageUrl, builder = {
                    placeholder(DEFAULT_IMAGE_PLACEHOLDER)
                }),
                    contentDescription =  stringResource(com.turbosokol.catskmm.android.R.string.kitty_image_descrition),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                    contentScale = ContentScale.FillWidth
                )
            }


            Column(modifier = Modifier.padding(8.dp)) {
//                Text(text = cat.tags.toString(), fontSize = 18.sp, fontWeight = FontWeight.Bold)
//                Text(text = cat.id!!)
//                Text(text = cat.created_at!!, fontStyle = FontStyle.Italic)
            }
        }
    }