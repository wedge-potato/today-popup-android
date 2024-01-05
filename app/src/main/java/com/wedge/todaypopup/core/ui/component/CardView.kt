package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.ui.theme.Grey10
import com.wedge.todaypopup.core.ui.theme.Grey60
import com.wedge.todaypopup.core.ui.theme.Grey70
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.theme.Subtitle2
import com.wedge.todaypopup.core.ui.theme.Subtitle3

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardView(
    modifier: Modifier = Modifier,
    image: String = "",
    title: String,
    subTitle: String,
    dueDate: String
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
        ) {
            if (image.isNotEmpty()) {
                GlideImage(
                    modifier = Modifier.fillMaxSize(),
                    model = image,
                    contentDescription = "card_image",
                    contentScale = ContentScale.Crop
                )
            } else {
                Spacer(
                    modifier = Modifier.fillMaxSize().background(Grey10)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.padding(horizontal = 2.dp)
        ) {
            Text(
                text = title,
                style = Subtitle2,
                color = Grey80,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subTitle,
                style = Subtitle3,
                color = Grey60,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "calendar_icon",
                    colorFilter = ColorFilter.tint(Grey70)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = dueDate,
                    style = Subtitle3,
                    color = Grey70,
                )
            }
        }
    }
}


@Preview
@Composable
private fun Preview_CardView() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        CardView(
            image = "https://image.dongascience.com/Photo/2020/03/5bddba7b6574b95d37b6079c199d7101.jpg",
            title = "TAMBURINS at The Hyundai Seoul",
            subTitle = "영등포구 ‧ 팝업스토어",
            dueDate = "2024.01.02 까지"
        )

        Spacer(Modifier.height(10.dp))

        CardView(
            title = "TAMBURINS at The Hyundai Seoul",
            subTitle = "영등포구 ‧ 팝업스토어",
            dueDate = "2024.01.02 까지"
        )
    }

}