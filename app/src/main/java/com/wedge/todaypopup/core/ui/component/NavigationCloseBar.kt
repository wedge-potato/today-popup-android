package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.theme.Subtitle1
import com.wedge.todaypopup.core.ui.util.clickableSingle

@Composable
fun NavigationCloseBar(
    modifier: Modifier = Modifier,
    text: String = "",
    rightContent: @Composable () -> Unit = {},
    closeButtonClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Image(
            modifier = Modifier.clickableSingle { closeButtonClick() },
            painter = painterResource(id = R.drawable.ic_nav_close),
            contentDescription = "close_button",
            colorFilter = ColorFilter.tint(Grey80)
        )

        if (text.isNotEmpty()) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text, style = Subtitle1)
        }

        Spacer(modifier = Modifier.weight(1f))

        rightContent()
    }
}

@Preview
@Composable
private fun Preview_NavigationCloseBar() {
    Column {
        NavigationCloseBar {

        }
        NavigationCloseBar(
            text = "hello"
        ) {

        }
        NavigationCloseBar(
            rightContent = {
                Text(text = "초기화")
            }
        ) {

        }
    }
}