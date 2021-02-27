/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.extensions.getGenderDrawableResource
import com.example.androiddevchallenge.repository.Doggo
import com.example.androiddevchallenge.repository.DoggoRepository
import com.example.androiddevchallenge.ui.DoggoSummaryBreed
import com.example.androiddevchallenge.ui.DoggoSummaryName
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class DetailActivity : AppCompatActivity() {

    private val repo = DoggoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val doggo = repo.getDoggoById(intent.getIntExtra(tagDoggoId, -1))

        doggo?.run {
            setContent {
                MyTheme {
                    DetailsScreen(this@DetailActivity, this)
                }
            }
        } ?: finish()
    }

    @Composable
    fun DetailsScreen(context: Context, doggo: Doggo) {
        Surface(color = MaterialTheme.colors.background) {
            Column() {
                DoggoHeaderImage(doggo)

                DoggoSummaryName(doggo)
                DoggoSummaryBreed(doggo)

                DoggoDetailText("Gender: ${doggo.gender}", doggo.getGenderDrawableResource())

                DoggoDetailText("Age: ${doggo.age}", R.drawable.ic_baseline_cake_24)

                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(8.dp)
                )

                Text(
                    text = "About Me",
                    modifier = Modifier.padding(8.dp),
                    style = typography.subtitle1
                )

                Text(
                    text = doggo.description,
                    modifier = Modifier.padding(8.dp),
                    style = typography.body2
                )
            }

//            FloatingActionButton(modifier = Modifier.size(80.dp, 80.dp),
//                onClick = {
//                    context.startActivity(Intent(Intent.ACTION_DIAL).apply {
//                        data = Uri.parse("tel:"+7775551234);
//                    })
//            }) {
//                Image(painter = painterResource(id = R.drawable.ic_baseline_phone_24), contentDescription = "Call")
//            }
        }
    }

    @Composable
    fun DoggoHeaderImage(doggo: Doggo) {
        Image(
            painter = painterResource(id = doggo.pictureResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(Dp(4f))),
        )
    }

    @Composable
    fun DoggoDetailText(text: String, iconResourceId: Int) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = iconResourceId),
                contentDescription = null
            )
            Text(
                text = text,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }

    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        val context = LocalContext.current
        val doggo = DoggoRepository().getDoggoById(0)

        MyTheme {
            DetailsScreen(context, doggo!!)
        }
    }

    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreview() {
        val context = LocalContext.current
        val doggo = DoggoRepository().getDoggoById(0)

        MyTheme(darkTheme = true) {
            DetailsScreen(context, doggo!!)
        }
    }

    companion object {
        private const val tagDoggoId = "__Doggo_Id__"
        fun createIntent(ctx: Context, doggoId: Int): Intent =
            Intent(ctx, DetailActivity::class.java).apply {
                putExtra(tagDoggoId, doggoId)
            }
    }
}
