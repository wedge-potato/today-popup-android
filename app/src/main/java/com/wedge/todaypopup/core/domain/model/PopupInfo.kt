package com.wedge.todaypopup.core.domain.model

data class PopupInfo(
	val id: Long,
	val thumbnail: String,
	val title: String,
	val date: String,
	val location: String
)