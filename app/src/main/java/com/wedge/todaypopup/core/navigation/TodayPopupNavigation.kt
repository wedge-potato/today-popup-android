package com.wedge.todaypopup.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.feature.home.HomeScreen

fun NavGraphBuilder.todayPopupHomeNavigation(
	navigator: TodayPopupNavigator,
	navHostController: NavHostController,
	selectedScreen: (route: String) -> Unit
) {
	composable(route = TodayPopupScreens.Home.name) {
		HomeScreen(navigator = navigator)
		selectedScreen(TodayPopupScreens.Home.name)
	}
}