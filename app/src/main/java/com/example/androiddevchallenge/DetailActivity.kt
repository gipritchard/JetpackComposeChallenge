package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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

                Box(modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(8.dp))

                Text(text = "About Me",
                    modifier = Modifier.padding(8.dp),
                    style = typography.subtitle1)

                Text(text = doggo.description,
                    modifier = Modifier.padding(8.dp),
                    style = typography.body2)

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
    fun DoggoDetailText(text:String, iconResourceId: Int) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(id = iconResourceId),
                contentDescription = null)
            Text(text = text,
                modifier = Modifier.padding(horizontal = 8.dp))
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
        fun createIntent(ctx: Context, doggoId: Int) : Intent =
            Intent(ctx, DetailActivity::class.java).apply {
                putExtra(tagDoggoId, doggoId)
            }
    }

}