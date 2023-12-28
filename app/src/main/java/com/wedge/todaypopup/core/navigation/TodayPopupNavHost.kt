package com.wedge.todaypopup.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator

@Composable
fun TodayPopupNavHost(
	modifier: Modifier = Modifier,
	navHostController: NavHostController,
	navigator: TodayPopupNavigator,
	selectedScreen: (route: String) -> Unit
) {
	NavHost(
		modifier = modifier,
		navController = navHostController,
		startDestination = TodayPopupScreens.Home.route
	) {
		todayPopupHomeNavigation(
			navigator = navigator,
			navHostController = navHostController,
			selectedScreen = selectedScreen
		)
	}
}
