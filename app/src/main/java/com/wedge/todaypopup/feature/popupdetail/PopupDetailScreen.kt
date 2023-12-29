package com.wedge.todaypopup.feature.popupdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.navigation.navigator.TodayPopupNavigatorImpl
import com.wedge.todaypopup.core.ui.util.clickableSingle

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PopupDetailScreen(
	modifier: Modifier = Modifier,
	navigator: TodayPopupNavigator = TodayPopupNavigatorImpl(),
	darkTheme: Boolean = isSystemInDarkTheme(),
	viewModel: PopupDetailViewModel = viewModel(),
) {

	val scrollState = rememberScrollState()

	LaunchedEffect(Unit) {
		viewModel.fetchDetailInfo()
	}

	Column(
		modifier = modifier
			.fillMaxSize()
			.background(if (darkTheme) Color(0xFF161616) else Color(0xFFF1F1F1))
			.verticalScroll(scrollState)
	) {
		PopupDetailTopBar(darkTheme = darkTheme) {
			navigator.navigateUp()
		}

		GlideImage(
			modifier = Modifier.aspectRatio(1f),
			model = viewModel.popupDetailInfo?.image ?: "",
			contentDescription = "popup_image"
		)

		PopupDetailInfoContent(
			darkTheme = darkTheme,
			title = viewModel.popupDetailInfo?.title ?: "",
			date = viewModel.popupDetailInfo?.date ?: "",
			time = viewModel.popupDetailInfo?.time ?: "",
			region = viewModel.popupDetailInfo?.region ?: ""
		)

		Spacer(modifier = Modifier
			.fillMaxWidth()
			.height(9.dp))

		PopupDetailInfoIntroduction(
			darkTheme = darkTheme,
			introduction = viewModel.popupDetailInfo?.introduction ?: ""
		)

		PopupDetailInfoAddress(
			darkTheme = darkTheme,
			address = viewModel.popupDetailInfo?.address ?: ""
		)

		PopupDetailInfoHomepage(
			darkTheme = darkTheme,
			homepage = viewModel.popupDetailInfo?.extra?.homepage ?: ""
		)
	}
}

@Composable
private fun PopupDetailInfoHomepage(
	modifier: Modifier = Modifier,
	darkTheme: Boolean,
	homepage: String
) {
	Column(
		modifier = modifier
			.fillMaxWidth()
			.background(if(darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(horizontal = 16.dp, vertical = 24.dp)
	) {
		Text(
			text = "홈페이지",
			style = TextStyle(
				fontSize = 16.sp,
				lineHeight = 20.8.sp,
				fontWeight = FontWeight(600),
				color = if(darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			)
		)
		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = homepage,
			style = TextStyle(
				fontSize = 15.sp,
				lineHeight = 19.5.sp,
				fontWeight = FontWeight.W500,
				color = if(darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			)
		)
	}
}

@Composable
private fun PopupDetailInfoAddress(
	darkTheme: Boolean,
	address: String
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(if(darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(vertical = 24.dp, horizontal = 16.dp)
	) {
		Text(
			text = "위치",
			style = TextStyle(
				fontSize = 16.sp,
				lineHeight = 20.8.sp,
				fontWeight = FontWeight.W600,
				color = if (darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111),
			)
		)

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = address,
			style = TextStyle(
				fontSize = 15.sp,
				lineHeight = 22.5.sp,
				fontWeight = FontWeight.W500,
				color = if(darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			)
		)

		Spacer(modifier = Modifier.height(8.dp))

		Spacer(
			modifier = Modifier
				.fillMaxWidth()
				.aspectRatio(3f)
				.clip(RoundedCornerShape(20.dp))
				.background(Color.LightGray)
		)
	}
}

@Composable
private fun PopupDetailInfoIntroduction(
	darkTheme: Boolean,
	introduction: String
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(if(darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(vertical = 24.dp, horizontal = 16.dp)
	) {
		Text(
			text = "소개",
			style = TextStyle(
				fontSize = 16.sp,
				lineHeight = 20.8.sp,
				fontWeight = FontWeight.W600,
				color = if (darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111),
			)
		)

		Spacer(modifier = Modifier.height(12.dp))

		Text(
			text = introduction,
			style = TextStyle(
				fontSize = 15.sp,
				lineHeight = 22.5.sp,
				fontWeight = FontWeight.W500,
				color = if(darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			)
		)
	}
}

@Composable
private fun PopupDetailInfoContent(
	darkTheme: Boolean,
	title: String,
	date: String,
	time: String,
	region: String
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(if(darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(horizontal = 16.dp, vertical = 20.dp)
	) {
		Text(
			text = "팝업스토어",
			style = TextStyle(
				fontSize = 11.sp,
				lineHeight = 14.3.sp,
				fontWeight = FontWeight.W700,
				color = if (darkTheme) Color(0xFFA0A0A0) else Color(0xFF4F4F4F)
			)
		)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = title,
			style = TextStyle(
				fontSize = 18.sp,
				lineHeight = 23.4.sp,
				fontWeight = FontWeight.W600,
				color = if (darkTheme) Color(0xFFF0F0F0) else Color(0xFF111111)
			)
		)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = date,
			style = TextStyle(
				fontSize = 15.sp,
				lineHeight = 19.5.sp,
				fontWeight = FontWeight.W500,
				color = if (darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			)
		)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = time,
			style = TextStyle(
				fontSize = 15.sp,
				lineHeight = 19.5.sp,
				fontWeight = FontWeight.W500,
				color = if (darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			)
		)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = region,
			style = TextStyle(
				fontSize = 15.sp,
				lineHeight = 19.5.sp,
				fontWeight = FontWeight.W500,
				color = if (darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			)
		)
	}
}

@Composable
private fun PopupDetailTopBar(
	modifier: Modifier = Modifier,
	darkTheme: Boolean,
	navigateUp: () -> Unit
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.background(if(darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(vertical = 12.dp, horizontal = 9.dp)
	) {
		Image(
			modifier = Modifier
				.size(24.dp)
				.clickableSingle {
					navigateUp()
				},
			painter = painterResource(id = R.drawable.ic_back),
			contentDescription = "ic_back",
			colorFilter = ColorFilter.tint(if (darkTheme) Color.White else Color(0xFF111111))
		)
	}
}

@Preview
@Composable
private fun Preview_PopupDetailScreen() {
	PopupDetailScreen()
}