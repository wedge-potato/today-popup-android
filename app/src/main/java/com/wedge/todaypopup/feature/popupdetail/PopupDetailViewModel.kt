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
			introduction = "탬버린즈(TAMBURINS)가 홀리데이 시즌을 맞아 더현대 서울에서 단독 팝업 스토어를 오픈합니다.\n" +
					"\n" +
					"이번 팝업 스토어는 성수 플래그십 스토어를 연상시키는 콘크리트 골조 인테리어를 중심으로 새로운 퍼퓸 컬렉션 8종과 알 모양 ‘더 에그 퍼퓸’ 3종 그리고 쉘 핸드 퍼퓸 3종을 선보입니다.\n" +
					"\n" +
					"연말 선물로도 제격인 ‘퍼퓸 캔들’은 펌키니부터 홀리메탈, 레이트어텀 그리고 베이더인더레이크까지 4가지의 다채로운 향으로 만나볼 수 있죠.\n" +
					"\n" +
					"또한 출시부터 품절 대란을 일으킨 ‘에그 립밤’ 4종을 구매하면 립밤을 패션 액세서리로도 활용할 수 있는 ‘퍼 키링’을 함께 증정한다는 소식! 탬버린즈의 더현대 서울 팝업 스토어는 12월 18일부터 31일까지 진행됩니다.",
			address = "서울시 성동구 성수동2가 273-13, 성수 에스팩토리 D동",
			extra = PopupDetailExtraData(
				homepage = "booking.kakao.com/detail/ticketStore/21869"
			)
		)
	}
}