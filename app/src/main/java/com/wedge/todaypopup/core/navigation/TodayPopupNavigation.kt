package com.wedge.todaypopup.core.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.feature.home.HomeScreen
import com.wedge.todaypopup.feature.popupdetail.PopupDetailScreen
import com.wedge.todaypopup.feature.setting.SettingScreen

fun NavGraphBuilder.todayPopupHomeNavigation(
	navigator: TodayPopupNavigator,
	navHostController: NavHostController,
	selectedScreen: (route: String) -> Unit
) {
	composable(route = TodayPopupScreens.Home.name) {
		HomeScreen(navigator = navigator)
		selectedScreen(TodayPopupScreens.Home.name)
	}

	composable(route = TodayPopupScreens.PopupDetail.name) {
		PopupDetailScreen(navigator = navigator)
		selectedScreen(TodayPopupScreens.PopupDetail.name)
	}

	composable(route = TodayPopupScreens.Setting.name) {
		Log.e("Test@@@", "Setting Composable")
		SettingScreen(navigator = navigator)
		selectedScreen(TodayPopupScreens.Setting.name)
	}
}