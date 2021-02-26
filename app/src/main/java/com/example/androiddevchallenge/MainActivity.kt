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
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androiddevchallenge.repository.Doggo
import com.example.androiddevchallenge.repository.DoggoRepository
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(this)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(context: Context) {
    Surface(color = MaterialTheme.colors.background) {
        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            items(DoggoRepository().getAllDoggos()) { doggo ->
                DoggoListEntry(doggo) {
                    val intent = DetailActivity.createIntent(context, doggo.id)
                    context.startActivity(intent)
                }
            }
        }
    }
}

//@Preview("Light Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun LightPreview() {
//    MyTheme {
//        MyApp()
//    }
//}
//
//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp()
//    }
//}

@Composable
fun DoggoListEntry(doggo: Doggo, onClick: () -> Unit) {
    Row(modifier = Modifier
        .padding(Dp(8f))
        .width(IntrinsicSize.Max)

        .clickable(onClick = onClick)) {
        Image(
            painter = painterResource(id = doggo.pictureResId),
            contentDescription = null,
            modifier = Modifier
                .size(Dp(100f), Dp(100f))
                .clip(shape = RoundedCornerShape(Dp(4f))),
        )
        Column(verticalArrangement = Arrangement.Bottom) {
            Text(text = "Name: ${doggo.name}", modifier = Modifier.padding(Dp(8f)))
            Text(text = "Breed: ${doggo.breed}", modifier = Modifier.padding(Dp(8f)))
        }
    }
}
