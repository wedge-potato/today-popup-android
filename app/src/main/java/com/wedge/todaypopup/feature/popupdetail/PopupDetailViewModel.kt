package com.wedge.todaypopup.feature.popupdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.wedge.todaypopup.core.domain.model.PopupDetailExtraData
import com.wedge.todaypopup.core.domain.model.PopupDetailInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopupDetailViewModel @Inject constructor(

) : ViewModel() {

	var popupDetailInfo by mutableStateOf<PopupDetailInfo?>(null)
		private set

	fun fetchDetailInfo() {
		popupDetailInfo = PopupDetailInfo(
			image = "https://lifezip.s3.ap-northeast-2.amazonaws.com/upload/1692366571_IMG_4717.jpeg",
			category = "팝업스토어",
			title = "빵빵이와 끼꼬의 크리스마스 팝업스토어",
			date = "2023.12.14 ~ 2023.12.27",
			time = "12:00 ~ 22:00",
			region = "서울시 성동구",
			introduction = "귀엽고 재밌는 빵빵이 굿즈들과 500평 규모의 초대형 스케일로 구성된 전시 공간, 콜라보 제품까지! 다양한 이야기와 볼거리가 어우러진  어쩌구",
			address = "서울시 성동구 성수동2가 273-13, 성수 에스팩토리 D동",
			extra = PopupDetailExtraData(
				homepage = "booking.kakao.com/detail/ticketStore/21869"
			)
		)
	}
}