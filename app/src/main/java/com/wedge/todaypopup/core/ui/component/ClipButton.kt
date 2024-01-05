package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.ui.theme.Caption1
import com.wedge.todaypopup.core.ui.theme.Caption3
import com.wedge.todaypopup.core.ui.theme.Coral60
import com.wedge.todaypopup.core.ui.theme.Grey30
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.theme.White

@Composable
fun ClipButton(
    modifier: Modifier = Modifier,
    text: String = "",
    filterSelected: Boolean = false,
    filterCnt: Int? = null
) {

    var clipButtonWidth  by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    Box(
        modifier = modifier
            .onGloballyPositioned {
                clipButtonWidth = with(density) {
                    it.size.width.toDp()
                }
            }
    ) {
		filterCnt?.let {
			FilterCountBall(
				modifier = Modifier.align(Alignment.TopEnd),
				count = filterCnt,
                parentWidth = clipButtonWidth
			)
		}

        ClipButtonContent(modifier, filterSelected, text)
    }

}

@Composable
private fun FilterCountBall(
    modifier: Modifier = Modifier,
    count: Int,
    parentWidth: Dp
) {
    val ratio = 12/81f

    Box(
        modifier = modifier
            .size(parentWidth*ratio)
			.clip(CircleShape)
			.background(Color.Red),
		contentAlignment = Alignment.Center
    ) {
        Text(
            text = count.toString(),
            style = Caption3,
            color = White
        )
    }
}

@Composable
private fun ClipButtonContent(
    modifier: Modifier,
    filterSelected: Boolean,
    text: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(32.dp),
                color = if (filterSelected) Coral60 else Grey30
            )
			.padding(vertical = 4.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_filter),
            colorFilter = ColorFilter.tint(if (filterSelected) Coral60 else Grey80),
            contentDescription = "ic_filter"
        )

        if (text.isNotEmpty()) {
            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = text,
                style = Caption1,
                color = if(filterSelected) Coral60 else Grey80
            )
        }
    }
}

@Preview
@Composable
private fun Preview_ClipButton() {
    Column {
		ClipButton(filterSelected = false)
		ClipButton(filterSelected = false, text = "지역")
		ClipButton(filterSelected = true)
		ClipButton(filterSelected = true, text = "지역")
		ClipButton(filterSelected = true, text = "지역", filterCnt = 3)
	}
}