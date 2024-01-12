package com.wedge.todaypopup.feature.service_inquire

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.navigation.navigator.TodayPopupNavigatorImpl
import com.wedge.todaypopup.core.ui.component.NavigationTextBackBar
import com.wedge.todaypopup.core.ui.theme.Caption1
import com.wedge.todaypopup.core.ui.theme.Grey10
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.theme.Subtitle2

@Composable
fun ServiceInquireScreen(
	modifier: Modifier = Modifier,
	navigator: TodayPopupNavigator = TodayPopupNavigatorImpl()
) {
	Column(
		modifier = modifier
			.fillMaxSize()
	) {
		NavigationTextBackBar(
			modifier = Modifier.fillMaxWidth(),
			text = "문의하기",
		) {
			navigator.navigateUp()
		}

		ServiceInquireMessageView(
			modifier = Modifier.fillMaxWidth()
		)

		ServiceInquireContentView()
	}
}

@Composable
private fun ServiceInquireMessageView(
	modifier: Modifier = Modifier,
) {
	Box(
		modifier = modifier
			.padding(20.dp)
			.background(color = Grey10, shape = RoundedCornerShape(8.dp))
	) {
		Text(
			modifier = Modifier
				.padding(vertical = 12.dp, horizontal = 20.dp),
			text = "서비스 이용에 문의할 내용이 있으신가요?\n편하게 제보해주세요",
			style = Caption1,
			color = Grey80
		)
	}
}

private data class ServiceInquireContent(
	@DrawableRes val iconRes: Int,
	val title: String,
	val route: String
)

@Composable
private fun ServiceInquireContentView(
	darkTheme: Boolean = false
) {
	val contentList = listOf(
		ServiceInquireContent(
			iconRes = R.drawable.ic_email,
			title = "메일 문의",
			route = ""
		),
		ServiceInquireContent(
			iconRes = R.drawable.ic_instagram,
			title = "문의하기" ,
			route = ""
		)
	)

	LazyColumn(
		modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
		verticalArrangement = Arrangement.spacedBy(16.dp)
	) {
		items(items = contentList, key = { it.title }) {
			ServiceInquireContentItem(
				content = it,
				darkTheme = darkTheme
			)
		}
	}
}

@Composable
private fun ServiceInquireContentItem(
	content: ServiceInquireContent,
	darkTheme: Boolean
) {
	Row(
		modifier = Modifier.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically
	) {
		Image(painter = painterResource(
			id = content.iconRes),
			contentDescription = "inquire_icon"
		)

		Spacer(modifier =Modifier.width(8.dp))

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

@Preview
@Composable
private fun Preview_ServiceInquireScreen() {
	ServiceInquireScreen()
}