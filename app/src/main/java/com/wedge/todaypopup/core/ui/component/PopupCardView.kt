package com.wedge.todaypopup.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wedge.todaypopup.core.ui.util.clickableSingle

@Composable
fun PopupCardView(
	modifier: Modifier = Modifier,
	darkTheme: Boolean,
	thumbnail: String,
	title: String,
	date: String,
	location: String,
	cardClick: () -> Unit = {}
) {
	Column(
		modifier = modifier
			.clickableSingle {
				cardClick()
			}
	) {
		ThumbnailView(thumbnail)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = title,
			style = TextStyle(
				fontSize = 14.sp,
				lineHeight = 18.2.sp,
				fontWeight = FontWeight.W600,
				color = if(darkTheme) Color(0xFFF4F4F4) else Color.Black
			)
		)
		Spacer(modifier = Modifier.height(4.dp))
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = date,
			style = TextStyle(
				fontSize = 11.sp,
				lineHeight = 14.3.sp,
				fontWeight = FontWeight.W600,
				color = if(darkTheme) Color(0xFFBFBFBF) else Color(0xFF686868)
			)
		)
		Spacer(modifier = Modifier.height(4.dp))
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = location,
			style = TextStyle(
				fontSize = 11.sp,
				lineHeight = 14.3.sp,
				fontWeight = FontWeight.W400,
				color = if(darkTheme) Color(0xFFBFBFBF) else Color(0xFF686868)
			)
		)
	}

}

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
private fun ThumbnailView(thumbnail: String) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.aspectRatio(1f)
			.clip(RoundedCornerShape(4.dp))
	) {
		GlideImage(
			modifier = Modifier.fillMaxSize(),
			model = thumbnail,
			contentDescription = "popup_thumbnail",
			contentScale = ContentScale.Crop
		)
	}
}

@Preview
@Composable
private fun Preview_PopupCardView() {
	PopupCardView(
		modifier = Modifier.background(Color.LightGray),
		darkTheme = isSystemInDarkTheme(),
		thumbnail = "https://cdn.imweb.me/upload/S201910012ff964777e0e3/62f9a36ea3cea.jpg",
		title = "빵빵이와 끼꼬의 크리스마스 팝업스토어",
		date = "2023.12.14 ~ 2023.12.27",
		location = "서울시 성동구"
	)
}