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
package com.example.androiddevchallenge.repository

data class Doggo(
    val id: Int,
    val name: String,
    val breed: String,
    val pictureResId: Int,
    val gender: String,
    val age: String,
    val description: String = "Lorem ipsum dolor sit amet, zril prompta discere mel an, at nec vivendo tibique. Probo impedit disputando usu ea. Te graeci repudiare eam, iusto ancillae suscipit ex eam. Inermis evertitur has te.\n" +
        "\n" +
        "Ei equidem detraxit efficiantur his. Ex per nisl consetetur. Ex zril decore mea, eu pro cibo vituperata, usu te ipsum laboramus. Et iusto populo eos. Mei mutat nonumy ea, ea probo utroque oporteat eum.\n" +
        "\n" +
        "Delicata patrioque mel ex, ad utamur adolescens theophrastus mea. Eum te quidam civibus. Elitr gloriatur ut qui. Ad mei quodsi labores deterruisset. Labores invidunt persequeris pri eu. Iudico perfecto cum ne, no mel tota conceptam intellegebat."
)
