package com.wedge.todaypopup.core.domain.model

data class PopupDetailInfo (
	val image: String,
	val category: String,
	val title: String,
	val date: String,
	val time: String,
	val region: String,
	val introduction: String,
	val address: String,
	val extra: PopupDetailExtraData
)

data class PopupDetailExtraData(
	val homepage: String
)