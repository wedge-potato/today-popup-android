package com.wedge.todaypopup.feature.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.navigation.TodayPopupScreens
import com.wedge.todaypopup.core.navigation.navigator.TodayPopupNavigatorImpl
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.theme.Subtitle2
import com.wedge.todaypopup.core.ui.util.clickableSingle

@Composable
fun SettingScreen(
	modifier: Modifier = Modifier,
	navigator: TodayPopupNavigator = TodayPopupNavigatorImpl(),
	darkTheme: Boolean = isSystemInDarkTheme()
) {
	Column(
		modifier = modifier
			.fillMaxSize()
	) {
		SettingTopBar(darkTheme = darkTheme) {
			navigator.navigateUp()
		}
		SettingContentView(darkTheme = darkTheme) { route ->
			if (route.isEmpty()) return@SettingContentView
			navigator.navigate(route)
		}
	}
}

private data class SettingContent(
	val title: String,
	val route: String
)

@Composable
private fun SettingContentView(
	darkTheme: Boolean,
	clickSettingContent: (route: String) -> Unit
) {
	val contentList = listOf(
		SettingContent("팝업스토어 제보하기", ""),
		SettingContent("문의하기" , TodayPopupScreens.ServiceInquire.name)
	)

	LazyColumn(
		modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
		verticalArrangement = Arrangement.spacedBy(16.dp)
	) {
		items(items = contentList, key = { it.title }) {
			SettingContentItem(
				content = it,
				darkTheme = darkTheme,
				clickSettingContent = clickSettingContent
			)
		}
	}
}

@Composable
private fun SettingContentItem(
	content: SettingContent,
	darkTheme: Boolean,
	clickSettingContent: (route: String) -> Unit
) {
	Row(
		modifier = Modifier.fillMaxWidth()
			.clickableSingle { clickSettingContent(content.route) },
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			modifier = Modifier.weight(1f),
			text = content.title,
			style = Subtitle2,
			color = Grey80
		)
		Image(
			modifier = Modifier.size(24.dp),
			painter = painterResource(id = R.drawable.ic_next),
			contentDescription = "ic_next",
			colorFilter = ColorFilter.tint(if(darkTheme) Color.White else Color(0xFF0B0B0B))
		)
	}
}

@Composable
private fun SettingTopBar(
	darkTheme: Boolean,
	navigateUp: () -> Unit
) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 9.dp, vertical = 8.dp)
	) {
		Image(
			modifier = Modifier
				.size(24.dp)
				.align(Alignment.CenterStart)
				.clickableSingle {
					navigateUp()
				},
			painter = painterResource(id = R.drawable.ic_nav_back),
			contentDescription = "ic_back",
			colorFilter = ColorFilter.tint(if(darkTheme) Color.White else Color(0xFF0B0B0B))
		)
		Text(
			modifier = Modifier.align(Alignment.Center),
			text = "설정",
			style = TextStyle(
				fontSize = 18.sp,
				lineHeight = 27.sp,
				fontWeight = FontWeight.W600,
				color = if(darkTheme) Color(0xFFFAFAFA) else Color(0xFF0B0B0B),
				textAlign = TextAlign.Center,
			)
		)
	}
}

@Preview
@Composable
private fun Preview_SettingScreen() {
	SettingScreen()
}