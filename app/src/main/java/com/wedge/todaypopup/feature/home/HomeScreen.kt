package com.wedge.todaypopup.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.domain.model.PopupInfo
import com.wedge.todaypopup.core.navigation.TodayPopupScreens
import com.wedge.todaypopup.core.navigation.navigator.TodayPopupNavigatorImpl
import com.wedge.todaypopup.core.ui.component.ClipButton
import com.wedge.todaypopup.core.ui.component.PopupCardView
import com.wedge.todaypopup.core.ui.theme.ThemeColors
import com.wedge.todaypopup.core.ui.util.clickableSingle

@Composable
fun HomeScreen(
	navigator: TodayPopupNavigator = TodayPopupNavigatorImpl(),
	darkTheme: Boolean = isSystemInDarkTheme(),
	viewModel: HomeViewModel = viewModel()
) {
	val themeColor = if (darkTheme) ThemeColors.DarkMode else ThemeColors.LightMode

	LaunchedEffect(Unit) {
		viewModel.fetchPopupInfoList()
	}

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(themeColor.background)
	) {
		HomeTopBar(
			themeColor = themeColor,
			darkTheme = darkTheme
		) {
			navigator.navigate(TodayPopupScreens.Setting.name)
		}
		HomeOptionRow(
			darkTheme = darkTheme
		)
		HomePopupContent(
			popupInfoList = viewModel.popupInfoList,
			darkTheme = darkTheme
		) {
			navigator.navigate(TodayPopupScreens.PopupDetail.name)
		}
	}
}

@Composable
private fun HomePopupContent(
	modifier: Modifier = Modifier,
	popupInfoList: List<PopupInfo>,
	darkTheme: Boolean,
	moveToPopupDetail: () -> Unit
) {
	Box(
		modifier = modifier.fillMaxSize()
			.padding(vertical = 6.dp, horizontal = 16.dp)
	) {
		LazyVerticalGrid(
			columns = GridCells.Fixed(2),
			verticalArrangement = Arrangement.spacedBy(28.dp),
			horizontalArrangement = Arrangement.spacedBy(9.dp)
		) {
			items(popupInfoList, key= { it.id } ) {
				PopupCardView(
					darkTheme = darkTheme,
					thumbnail = it.thumbnail,
					title = it.title,
					date = it.date,
					location = it.location
				) {
					moveToPopupDetail()
				}
			}
		}
	}
}

@Composable
private fun HomeOptionRow(
	darkTheme: Boolean
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 16.dp, horizontal = 13.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		ClipButton()
		FilterText(darkTheme = darkTheme)
	}
}

@Composable
private fun FilterText(
	darkTheme: Boolean
) {
	val color = if (darkTheme) Color(0xFFEAEAEA) else Color(0xFF212121)

	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Center
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_filter),
			contentDescription = "filter_icon",
			colorFilter = ColorFilter.tint(color)
		)
		Spacer(modifier = Modifier.width(4.dp))
		Text(
			text = "최신 오픈순",
			style = TextStyle(
				fontSize = 12.sp,
				lineHeight = 15.6.sp,
				fontWeight = FontWeight.W600,
				color = color
			)
		)
	}
}

@Composable
private fun HomeTopBar(
	themeColor: ThemeColors,
	darkTheme: Boolean,
	navigateToSetting: () -> Unit
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 12.dp, horizontal = 16.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_logo),
			contentDescription = "logo"
		)
		Spacer(modifier = Modifier.width(4.dp))
		Text(
			text = "홈",
			style = TextStyle(
				fontSize = 18.sp,
				lineHeight = 27.sp,
				fontWeight = FontWeight.W700,
				color = themeColor.text,
				textAlign = TextAlign.Center,
			)
		)
		Spacer(modifier = Modifier.weight(1f))
		Image(
			modifier = Modifier
				.size(24.dp)
				.clickableSingle {
					navigateToSetting()
				},
			painter = painterResource(id = R.drawable.ic_setting),
			contentDescription = "ic_setting_white",
			colorFilter = ColorFilter.tint(
				color = if (darkTheme) Color(0xFFFAFAFA) else Color(0xFF131313)
			)
		)
	}
}

@Preview
@Composable
private fun Preview_HomeScreen() {
	HomeScreen()
}