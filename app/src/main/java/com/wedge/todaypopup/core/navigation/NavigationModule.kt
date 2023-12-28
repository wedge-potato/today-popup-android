package com.wedge.todaypopup.core.navigation

import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.core.navigation.navigator.TodayPopupNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface NavigationModule {

	@Binds
	fun provideTodayPopupNavigator(
		todayPopupNavigatorImpl: TodayPopupNavigatorImpl
	) : TodayPopupNavigator
}