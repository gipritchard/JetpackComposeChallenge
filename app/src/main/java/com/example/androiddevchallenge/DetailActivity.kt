package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.repository.Doggo
import com.example.androiddevchallenge.repository.DoggoRepository
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {

    private val repo = DoggoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val doggo = repo.getDoggoById(intent.getIntExtra(tagDoggoId, -1))

        doggo?.run {
            setContent {
                MyTheme {
                    DoggoView(this)
                }
            }
        } ?: finish()

    }



    @Composable
    fun DetailsScreen(doggo: Doggo) {
        DoggoView(doggo)
    }


    @Composable
    fun DoggoView(doggo: Doggo) {
        Column {
            Image(
                painter = painterResource(id = doggo.pictureResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(Dp(4f))),
            )
        }
    }


    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        val context = LocalContext.current
        val doggo = DoggoRepository().getDoggoById(0)

        MyTheme {
            DetailsScreen(doggo!!)
        }
    }

    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreview() {
        val context = LocalContext.current
        val doggo = DoggoRepository().getDoggoById(0)

        MyTheme(darkTheme = true) {
            DetailsScreen(doggo!!)
        }
    }


    companion object {
        private const val tagDoggoId = "__Doggo_Id__"
        fun createIntent(ctx: Context, doggoId: Int) : Intent =
            Intent(ctx, DetailActivity::class.java).apply {
                putExtra(tagDoggoId, doggoId)
            }
    }

}