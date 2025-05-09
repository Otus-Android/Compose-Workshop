package ru.otus.compose.workshop.examples.side.finish

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.otus.compose.workshop.R

data class CatsState(
    val images: List<Int>,
)

@Composable
fun LaunchedEffectExample(
    state: CatsState
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
    ) { 2 }

    var current by remember { mutableIntStateOf(0) }
    LaunchedEffect(current) {
        pagerState.animateScrollToPage(
            page = current,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 0,
                easing = LinearEasing,
            )
        )
    }

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.size(400.dp),
            contentPadding = PaddingValues(horizontal = 40.dp)
        ) { page ->
            Image(
                painter = painterResource(id = state.images[page]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(300.dp)
            )
        }

        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { current = 0 },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Left")
            }
            Button(
                onClick = { current = 1 },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Right")
            }
        }
    }
}


@Preview
@Composable
fun LaunchedEffectExamplePreview() {
    Surface {
        LaunchedEffectExample(
            state = CatsState(
                images = listOf(
                    R.drawable.cat,
                    R.drawable.cat2,
                ),
            )
        )
    }
}