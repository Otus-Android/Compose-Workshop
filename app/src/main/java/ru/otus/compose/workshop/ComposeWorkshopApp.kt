package ru.otus.compose.workshop

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ru.otus.compose.workshop.productcard.finish.ProductCard
import ru.otus.compose.workshop.productcard.finish.ProductCardStateCreator

@Composable
fun ComposeWorkshopApp() {
    Surface {
        var selectedImage by remember { mutableIntStateOf(0) }
        var selectedColor by remember { mutableIntStateOf(0) }
        var selectedSize by remember { mutableIntStateOf(2) }
        var isLiked by remember { mutableStateOf(false) }

        ProductCard(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize(),
            state = ProductCardStateCreator.create(selectedImage, selectedColor, selectedSize, isLiked),
            onColorClicked = { newColor ->
                selectedColor = newColor
                selectedImage = newColor
            },
            onSizeClicked = { newSize ->
                selectedSize = newSize
            },
            onLiked = { newIsLiked ->
                isLiked = !newIsLiked
            }
        )
    }
}