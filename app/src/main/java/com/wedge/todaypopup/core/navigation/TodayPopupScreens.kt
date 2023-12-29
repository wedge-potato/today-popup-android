package com.wedge.todaypopup.core.navigation

import androidx.navigation.NamedNavArgument

sealed class TodayPopupScreens(
	val route: String,
	navArguments: List<NamedNavArgument> = emptyList()
) {
	val name: String = route.appendArguments(navArguments)

	object Home : TodayPopupScreens("home")

	object PopupDetail : TodayPopupScreens("popup/detail")

	object Setting : TodayPopupScreens("setting")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
	val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
		.takeIf { it.isNotEmpty() }
		?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
		.orEmpty()

	val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
		.takeIf { it.isNotEmpty() }
		?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
		.orEmpty()

	return "$this$mandatoryArguments$optionalArguments"
}