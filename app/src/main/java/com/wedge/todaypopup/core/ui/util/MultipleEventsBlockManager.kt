package com.wedge.todaypopup.core.ui.util

interface MultipleEventsBlockManager {
	fun processEvent(event: () -> Unit)

	companion object
}