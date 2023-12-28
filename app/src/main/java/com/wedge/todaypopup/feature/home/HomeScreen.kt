package com.wedge.todaypopup.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator

@Composable
fun HomeScreen(
	navigator: TodayPopupNavigator
) {
	Box(
		modifier = Modifier.fillMaxSize()
	) {
		Text(
			modifier = Modifier.align(Alignment.Center),
			text = "Test"
		)
	}
}