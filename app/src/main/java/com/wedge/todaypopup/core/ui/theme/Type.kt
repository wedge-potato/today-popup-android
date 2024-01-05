package com.wedge.todaypopup.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
	bodyLarge = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	)
	/* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Header1 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.Bold,
	fontSize = 24.sp,
	lineHeight = 32.sp
)

val Subtitle1 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.SemiBold,
	fontSize = 18.sp,
	lineHeight = 24.sp
)

val Subtitle2 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.SemiBold,
	fontSize = 16.sp,
	lineHeight = 24.sp
)

val Subtitle3 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.Medium,
	fontSize = 12.sp,
	lineHeight = 18.sp
)

val Body1 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.Normal,
	fontSize = 16.sp,
	lineHeight = 24.sp
)

val Body2 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.Medium,
	fontSize = 14.sp,
	lineHeight = 2.sp
)

val Caption1 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.SemiBold,
	fontSize = 12.sp,
	lineHeight = 18.sp
)

val Caption2 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.Bold,
	fontSize = 10.sp,
	lineHeight = 12.sp
)

val Caption3 = TextStyle(
	fontFamily = suit,
	fontWeight = FontWeight.SemiBold,
	fontSize = 8.sp,
	lineHeight = 10.sp
)