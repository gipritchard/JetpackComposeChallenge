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
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.repository.Doggo
import com.example.androiddevchallenge.repository.DoggoRepository
import com.example.androiddevchallenge.ui.DoggoSummaryBreed
import com.example.androiddevchallenge.ui.DoggoSummaryImage
import com.example.androiddevchallenge.ui.DoggoSummaryName
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val doggos = DoggoRepository().getAllDoggos().sortedBy { d -> d.name }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(this, doggos)
            }
        }
    }

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {

    val context = LocalContext.current
    val doggos = DoggoRepository().getAllDoggos().sortedBy { d -> d.name }

    MyTheme {
        MyApp(context, doggos)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {

    val context = LocalContext.current
    val doggos = DoggoRepository().getAllDoggos().sortedBy { d -> d.name }

    MyTheme(darkTheme = true) {
        MyApp(context, doggos)
    }
}

// Start building your app here!
@Composable
fun MyApp(context: Context, goodBois: List<Doggo>) {
    Surface(color = MaterialTheme.colors.background) {
        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            items(goodBois) { doggo ->
                DoggoListEntry(doggo) {
                    val intent = DetailActivity.createIntent(context, doggo.id)
                    context.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun DoggoListEntry(doggo: Doggo, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = Dp(2f)
    ) {
        Row(modifier = Modifier
            .padding(Dp(8f))
            .fillMaxWidth()) {
            DoggoSummaryImage(doggo)
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()) {
                DoggoSummaryName(doggo)
                DoggoSummaryBreed(doggo)
            }
        }
    }
}
