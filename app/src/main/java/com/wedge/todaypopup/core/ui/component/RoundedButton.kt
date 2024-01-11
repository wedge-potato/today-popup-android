package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wedge.todaypopup.core.ui.util.clickableSingle

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    textColor: Color = Color.Unspecified,
    roundDp: Dp = 0.dp,
    buttonColor: Color = Color.Unspecified,
    horizontalPaddingDp: Dp = 16.dp,
    verticalPaddingDp: Dp = 10.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(roundDp))
            .background(buttonColor)
            .padding(vertical = verticalPaddingDp, horizontal = horizontalPaddingDp)
            .clickableSingle { onClick() }
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = text,
            style = textStyle,
            color = textColor
        )
    }
}