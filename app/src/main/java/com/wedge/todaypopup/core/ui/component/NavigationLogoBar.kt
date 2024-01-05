package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.ui.theme.Coral60
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.util.clickableSingle

@Composable
fun NavigationLogoBar(
    modifier: Modifier = Modifier,
    settingIconClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            colorFilter = ColorFilter.tint(Coral60)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_logo_text),
            contentDescription = "logo_text",
            colorFilter = ColorFilter.tint(Grey80)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.clickableSingle { settingIconClick() },
            painter = painterResource(id = R.drawable.ic_setting),
            contentDescription = "setting_icon",
            colorFilter = ColorFilter.tint(Grey80)
        )
    }
}

@Preview
@Composable
private fun Preview_NavigationLogoBar() {
    NavigationLogoBar()
}