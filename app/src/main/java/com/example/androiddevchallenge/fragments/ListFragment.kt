package com.example.androiddevchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.fragment.app.Fragment
import com.example.androiddevchallenge.R

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }


    @Composable
    fun doggoListEntry(name:String, breed:String, pictureResId: Int) {
        Row(modifier = Modifier.padding(Dp(8f))) {
            Image(
                painter = painterResource(id = pictureResId),
                contentDescription = null,
                modifier = Modifier.size(Dp(100f), Dp(100f))
                    .clip(shape = RoundedCornerShape(Dp(4f))),
            )
            Column(verticalArrangement = Arrangement.Bottom) {
                Text(text = "Name: $name", modifier = Modifier.padding(Dp(8f)))
                Text(text = "Breed: $breed", modifier = Modifier.padding(Dp(8f)))
            }
        }
    }

    @Preview
    @Composable
    fun PreviewScreen() {
        Column {
            doggoListEntry(name = "DuckHunt", breed = "Wombo Combo", pictureResId = R.drawable.duckhunt)
            doggoListEntry(name = "KK Slider", breed = "White Wolf", pictureResId = R.drawable.animalcrossing)
            doggoListEntry(name = "Cerberus", breed = "Under World", pictureResId = R.drawable.cerberus)
            doggoListEntry(name = "Dog Meat", breed = "Apocalypse", pictureResId = R.drawable.dogmeat)
        }
    }


}