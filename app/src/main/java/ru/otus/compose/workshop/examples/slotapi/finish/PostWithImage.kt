package ru.otus.compose.workshop.examples.slotapi.finish

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.otus.compose.workshop.R

@Immutable
class PostWithImageState(
    profileState: ProfileState,
    val postImage: Int
) : PostState(profileState = profileState)

@Composable
fun PostWithImage(
    state: PostWithImageState,
    modifier: Modifier = Modifier,
) {
    Post(
        modifier = modifier,
        userSection = {
            Profile(
                profileState = state.profileState
            )
        },
        postSection = {
            Image(
                painter = painterResource(id = state.postImage),
                modifier = Modifier
                    .fillMaxWidth(),
                contentDescription = null
            )
        },
        buttonsSection = { BottomButtons() },
    )
}

@Preview
@Composable
fun PostWithImagePreview() {
    Surface(color = MaterialTheme.colorScheme.background) {
        PostWithImage(
            state = PostWithImageState(
                profileState = ProfileState(
                    userImage = R.drawable.profile,
                    userName = stringResource(R.string.profile_name),
                    postDate = stringResource(R.string.post_date)
                ),
                postImage = R.drawable.cat
            )
        )
    }
}
