package com.wedge.todaypopup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.core.navigation.TodayPopupNavHost

@Composable
fun TodayPopupApp(
	navigator: TodayPopupNavigator
) {
	val navController = rememberNavController()

	LaunchedEffect(Unit) {
		navigator.handleNavigationCommands(navController)
	}

	Box(
		modifier = Modifier.fillMaxSize()
	) {
		TodayPopupNavHost(
			navHostController = navController,
			navigator = navigator
		) {
//			navigator.navigate(it)
		}
	}
}