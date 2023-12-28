package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wedge.todaypopup.R

@Composable
fun ClipButton(
	modifier: Modifier = Modifier,
	darkTheme: Boolean
) {
	val color = if (darkTheme) Color(0xFFEAEAEA) else Color(0xFF212121)

	Row(
		modifier = modifier
			.border(
				width = 1.dp,
				shape = RoundedCornerShape(100.dp),
				color = Color(0xFFEAEAEA)
			)
			.padding(vertical = 4.dp, horizontal = 16.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Center
	) {
		Image(
			modifier = Modifier.size(21.dp),
			painter = painterResource(id = R.drawable.ic_options),
			colorFilter = ColorFilter.tint(color),
			contentDescription = "ic_option"
		)

		Spacer(modifier = Modifier.width(4.dp))

		Text(
			text = "지역",
			style = TextStyle(
				fontSize = 12.sp,
				lineHeight = 15.6.sp,
				fontWeight = FontWeight.W600,
				color = color
			)
		)
	}
}

@Preview
@Composable
private fun Preview_ClipButton() {
	ClipButton(darkTheme = isSystemInDarkTheme())
}