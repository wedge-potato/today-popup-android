package com.wedge.todaypopup.feature.popupdetail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.navigation.navigator.TodayPopupNavigatorImpl
import com.wedge.todaypopup.core.ui.component.NavigationTextBackBar
import com.wedge.todaypopup.core.ui.theme.Body1
import com.wedge.todaypopup.core.ui.theme.Body2
import com.wedge.todaypopup.core.ui.theme.Caption1
import com.wedge.todaypopup.core.ui.theme.Coral60
import com.wedge.todaypopup.core.ui.theme.Grey20
import com.wedge.todaypopup.core.ui.theme.Grey50
import com.wedge.todaypopup.core.ui.theme.Grey60
import com.wedge.todaypopup.core.ui.theme.Grey70
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.theme.Header1
import com.wedge.todaypopup.core.ui.theme.HyperLink
import com.wedge.todaypopup.core.ui.theme.Subtitle1
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
		NavigationTextBackBar(
			modifier = Modifier.fillMaxWidth()
		) {
			navigator.navigateUp()
		}

		ImageSlideView(
			modifier = Modifier.fillMaxWidth(),
			imageList = listOf(
				"https://lifezip.s3.ap-northeast-2.amazonaws.com/upload/1692366571_IMG_4717.jpeg",
				"https://lifezip.s3.ap-northeast-2.amazonaws.com/upload/1692366571_IMG_4717.jpeg",
				"https://lifezip.s3.ap-northeast-2.amazonaws.com/upload/1692366571_IMG_4717.jpeg",
				"https://lifezip.s3.ap-northeast-2.amazonaws.com/upload/1692366571_IMG_4717.jpeg",
				"https://lifezip.s3.ap-northeast-2.amazonaws.com/upload/1692366571_IMG_4717.jpeg"
			)
		)

		PopupDetailInfoContent(
			darkTheme = darkTheme,
			title = viewModel.popupDetailInfo?.title ?: "",
			date = viewModel.popupDetailInfo?.date ?: "",
			time = viewModel.popupDetailInfo?.time ?: "",
			region = viewModel.popupDetailInfo?.region ?: "",
			link = "https://www.instagram.com/p/Cs8UYdivFQ9/?igshid=MTI1ZDU5ODQ3Yw%3D%3D"
		)

		Spacer(modifier = Modifier.fillMaxWidth().height(9.dp))

		PopupDetailInfoIntroduction(
			darkTheme = darkTheme,
			introduction = viewModel.popupDetailInfo?.introduction ?: ""
		)

		Spacer(modifier = Modifier.fillMaxWidth().height(9.dp))

		PopupDetailInfoAddress(
			darkTheme = darkTheme,
			address = viewModel.popupDetailInfo?.address ?: ""
		)
	}
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
private fun ImageSlideView(
	modifier: Modifier = Modifier,
	imageList: List<String>
) {
	val pagerState = rememberPagerState(pageCount = { 5 })

	Box(
		modifier = modifier
			.fillMaxWidth()
			.aspectRatio(1f),
	) {
		HorizontalPager(
			modifier = Modifier.fillMaxSize(),
			state = pagerState
		) { page ->
			GlideImage(
				modifier = Modifier.aspectRatio(1f),
				model = imageList[page],
				contentDescription = "popup_image"
			)
		}

		Row(
			Modifier
				.wrapContentHeight()
				.fillMaxWidth()
				.align(Alignment.BottomCenter)
				.padding(bottom = 8.dp),
			horizontalArrangement = Arrangement.Center
		) {
			repeat(pagerState.pageCount) { iteration ->
				val color = if (pagerState.currentPage == iteration) Coral60 else Grey20

				Box(
					modifier = Modifier
						.clip(CircleShape)
						.background(color)
						.size(6.dp)
				)

				if (iteration != pagerState.pageCount) {
					Spacer(modifier = Modifier.width(8.dp))
				}
			}
		}
	}
}

@Composable
private fun PopupDetailInfoContent(
	darkTheme: Boolean,
	title: String,
	date: String,
	time: String,
	region: String,
	link: String
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(if (darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(horizontal = 20.dp, vertical = 20.dp)
	) {
		Text(
			text = "팝업스토어",
			style = Caption1,
			color = Coral60
		)

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			modifier = Modifier.fillMaxWidth(),
			text = title,
			style = Header1,
			color = Grey80
		)

		Spacer(modifier = Modifier.height(8.dp))

		PopupDetailInfoContentBody(
			modifier = Modifier.fillMaxWidth(),
			iconRes = R.drawable.ic_calendar,
			text = date
		)

		Spacer(modifier = Modifier.height(8.dp))

		PopupDetailInfoContentBody(
			modifier = Modifier.fillMaxWidth(),
			iconRes = R.drawable.ic_time,
			text = time
		)

		Spacer(modifier = Modifier.height(8.dp))

		PopupDetailInfoContentBody(
			modifier = Modifier.fillMaxWidth(),
			iconRes = R.drawable.ic_location,
			text = region
		)

		Spacer(modifier = Modifier.height(8.dp))

		PopupDetailInfoContentBody(
			modifier = Modifier.fillMaxWidth(),
			iconRes = R.drawable.ic_link,
			text = link,
			isHyperLink = true
		)
	}
}

@Composable
private fun PopupDetailInfoContentBody(
	modifier: Modifier = Modifier,
	@DrawableRes iconRes: Int,
	text: String,
	isHyperLink: Boolean = false
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Image(
			modifier = Modifier.size(22.dp),
			painter = painterResource(id = iconRes),
			contentDescription = "icon",
			colorFilter = ColorFilter.tint(Grey70)
		)

		Spacer(modifier = Modifier.width(8.dp))

		val uriHandler = LocalUriHandler.current

		Text(
			modifier = Modifier
				.weight(1f)
				.clickableSingle {
					if (!isHyperLink) return@clickableSingle
					uriHandler.openUri(text)
				},
			text = text,
			style = Body2,
			color = if (isHyperLink) HyperLink else Grey70,
			maxLines = 1,
			overflow = TextOverflow.Ellipsis
		)
	}
}

@Composable
private fun PopupDetailInfoIntroduction(
	darkTheme: Boolean,
	introduction: String
) {

	var isCheckLineCount by remember { mutableStateOf(false) }
	var needToFoldIntroduction by remember { mutableStateOf(false) }

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(if (darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(vertical = 24.dp, horizontal = 16.dp)
	) {
		Text(
			text = "소개",
			style = Body1,
			color = Grey50
		)

		Spacer(modifier = Modifier.height(12.dp))

		Text(
			text = introduction,
			style = TextStyle(
				fontSize = 15.sp,
				lineHeight = 22.5.sp,
				fontWeight = FontWeight.W500,
				color = if (darkTheme) Color(0xFFEFEFEF) else Color(0xFF111111)
			),
			maxLines = if(needToFoldIntroduction) 9 else Int.MAX_VALUE,
			overflow = TextOverflow.Ellipsis,
			onTextLayout = {  textLayoutResult ->
				if (isCheckLineCount) return@Text
				isCheckLineCount = true
				needToFoldIntroduction = textLayoutResult.lineCount >= 9
			}
		)

		Spacer(modifier = Modifier.height(12.dp))

		Text(
			modifier = Modifier.clickableSingle {
				needToFoldIntroduction = !needToFoldIntroduction
			},
			text = if(needToFoldIntroduction) "접기" else "펼치기",
			style = Body2,
			color = Grey60
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
			.background(if (darkTheme) Color(0xFF111111) else Color(0xFFFAFAFA))
			.padding(vertical = 24.dp, horizontal = 16.dp)
	) {
		Text(
			text = "위치",
			style = Subtitle1,
			color = Grey80
		)

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = address,
			style = Body1,
			color = Grey50
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

@Preview
@Composable
private fun Preview_PopupDetailScreen() {
	PopupDetailScreen()
}