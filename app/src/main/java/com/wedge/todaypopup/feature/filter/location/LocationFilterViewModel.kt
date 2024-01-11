package com.wedge.todaypopup.feature.filter.location

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.wedge.todaypopup.core.domain.model.Area
import com.wedge.todaypopup.core.domain.model.Region
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationFilterViewModel @Inject constructor() : ViewModel() {

    var regionList by mutableStateOf<List<Region>>(emptyList())
        private set

    var areaList by mutableStateOf<List<Area>>(emptyList())
        private set

    fun fetchRegionList() {
        regionList = listOf(
            Region(
                id = 1L,
                name = "서울",
                isSelected = true
            ),
            Region(
                id = 2L,
                name = "A",
                isSelected = false
            ),
            Region(
                id = 3L,
                name = "B",
                isSelected = false
            ),
            Region(
                id = 4L,
                name = "C",
                isSelected = false
            )
        )
    }

    fun fetchAreaList() {
        areaList = listOf(
            Area(
                id = 2L,
                name = "강남구"
            ),
            Area(
                id = 3L,
                name = "서초구"
            ),
            Area(
                id = 4L,
                name = "성동구"
            ),
            Area(
                id = 5L,
                name = "광진구"
            ),
            Area(
                id = 6L,
                name = "마포구"
            ),
            Area(
                id = 7L,
                name = "송파구"
            ),
            Area(
                id = 8L,
                name = "용산구"
            ), Area(
                id = 9L,
                name = "강남구"
            ),
            Area(
                id = 10L,
                name = "종로구"
            ),
            Area(
                id = 11L,
                name = "은평구"
            )
        )
    }

    fun selectRegion(selectedIndex: Int) {
        regionList = regionList.mapIndexed { index, region ->
            if (index == selectedIndex) region.select() else region.unSelect()
        }
    }

    fun selectArea(selectedIndex: Int) {
        areaList = areaList.mapIndexed { index, area ->
            if (index == selectedIndex) area.select() else area.unSelect()
        }
    }
}