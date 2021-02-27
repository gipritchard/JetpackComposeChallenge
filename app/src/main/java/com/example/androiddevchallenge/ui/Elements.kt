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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.repository.Doggo
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun DoggoSummaryImage(doggo: Doggo) {
    Image(
        painter = painterResource(id = doggo.pictureResId),
        contentDescription = null,
        modifier = Modifier
            .size(Dp(100f), Dp(100f))
            .clip(shape = RoundedCornerShape(Dp(4f))),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun DoggoSummaryName(doggo: Doggo) {
    Text(
        text = doggo.name,
        modifier = Modifier.padding(horizontal = 8.dp),
        style = typography.h6,
        color = MaterialTheme.colors.primary
    )
}

@Composable
fun DoggoSummaryBreed(doggo: Doggo) {
    Text(
        text = "Breed: ${doggo.breed}",
        modifier = Modifier.padding(Dp(8f)),
        style = typography.subtitle1,
        fontStyle = FontStyle.Italic
    )
}
