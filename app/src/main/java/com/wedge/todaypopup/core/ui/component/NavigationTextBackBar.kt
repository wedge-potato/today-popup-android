package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun NavigationTextBackBar(
    modifier: Modifier = Modifier,
    text: String = "",
    onBackPressed: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.clickableSingle { onBackPressed() },
            painter = painterResource(id = R.drawable.ic_nav_back),
            contentDescription = "back_icon",
            colorFilter = ColorFilter.tint(Grey80)
        )

        if (text.isNotEmpty()) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = Subtitle1
            )
        }
    }
}

@Preview
@Composable
private fun Preview_NavigationTextBackBar() {
    Column {
        NavigationTextBackBar(
            text = "Hello"
        ) {

        }
        NavigationTextBackBar() {

        }
    }
}