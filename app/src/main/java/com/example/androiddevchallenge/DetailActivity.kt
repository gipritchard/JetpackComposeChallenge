package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.androiddevchallenge.repository.Doggo
import com.example.androiddevchallenge.repository.DoggoRepository

class DetailActivity : AppCompatActivity() {

    private val repo = DoggoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val doggo = repo.getDoggoById(intent.getIntExtra(tagDoggoId, -1))
        if (doggo == null) {
            finish()
            return
        }

        setContent {
            DoggoView(doggo = doggo)
        }
    }

    @Composable
    fun DoggoView(doggo: Doggo) {
        Column {
            Image(
                painter = painterResource(id = doggo.pictureResId),
                contentDescription = null,
                modifier = Modifier
                    .size(Dp(100f), Dp(100f))
                    .clip(shape = RoundedCornerShape(Dp(4f))),
            )
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