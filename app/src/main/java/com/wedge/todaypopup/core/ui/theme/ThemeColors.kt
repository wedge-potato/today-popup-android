package com.wedge.todaypopup.core.ui.theme

import androidx.compose.ui.graphics.Color

sealed class ThemeColors(
	val background: Color,
	val text: Color
) {
	object DarkMode: ThemeColors(
		background = dark_mode_bg,
		text = dark_mode_text
	)
	object LightMode: ThemeColors(
		background = light_mode_bg,
		text = light_mode_text
	)
}