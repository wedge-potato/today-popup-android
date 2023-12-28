package com.wedge.todaypopup.feature.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.wedge.todaypopup.core.domain.model.PopupInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

	var popupInfoList by mutableStateOf<List<PopupInfo>>(emptyList())
		private set

	fun fetchPopupInfoList() {
		popupInfoList = listOf(
			PopupInfo(
				id = 1L,
				thumbnail = "https://res.klook.com/image/upload/q_85/c_fill,w_750/v1617101647/blog/edlhmuf96dpqcnodl9qf.jpg",
				title = "A",
				date = "1~2",
				location = "서울"
			),
			PopupInfo(
				id = 2L,
				thumbnail = "https://media.istockphoto.com/id/1500563478/ko/%EC%82%AC%EC%A7%84/%ED%83%9C%EA%B5%AD-%EC%88%98%EB%9E%8F%ED%83%80%EB%8B%88-%EC%B9%B4%EC%98%A4%EC%86%8D-%EA%B5%AD%EB%A6%BD%EA%B3%B5%EC%9B%90%EC%9D%98-%EB%9E%8F%EC%B0%A8%ED%94%84%EB%9D%BC%ED%8C%8C-%EB%8C%90%EC%97%90%EC%84%9C-%ED%83%9C%EA%B5%AD-%EB%A1%B1%ED%85%8C%EC%9D%BC-%EB%B3%B4%ED%8A%B8%EB%A5%BC-%ED%83%80%EA%B3%A0-%ED%9C%B4%EC%8B%9D%EC%9D%84-%EC%B7%A8%ED%95%98%EB%8A%94-%EC%95%84%EC%8B%9C%EC%95%84-%EC%97%AC%EC%84%B1.webp?b=1&s=170667a&w=0&k=20&c=HWtsr9unvb6FDaWilQtPsJbZDkRaD04DDInoovFtyz8=",
				title = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",
				date = "1~2",
				location = "서울"
			),
			PopupInfo(
				id = 3L,
				thumbnail = "https://www.ibabynews.com/news/photo/201912/80486_29266_4502.jpg",
				title = "A",
				date = "1~2",
				location = "서울"
			),
			PopupInfo(
				id = 4L,
				thumbnail = "https://www.kkday.com/ko/blog/wp-content/uploads/sep_abroad_1.jpeg",
				title = "A",
				date = "1~2",
				location = "서울"
			),
			PopupInfo(
				id = 5L,
				thumbnail = "https://tgzzmmgvheix1905536.cdn.ntruss.com/2020/03/5a9efd73692d49b5b74ebf205baaae01",
				title = "A",
				date = "1~2",
				location = "서울"
			),
		)
	}
}