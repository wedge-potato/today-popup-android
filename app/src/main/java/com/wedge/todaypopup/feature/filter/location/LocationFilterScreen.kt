package com.wedge.todaypopup.feature.filter.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wedge.drawingtoyou.core.navigation.navigator.TodayPopupNavigator
import com.wedge.todaypopup.R
import com.wedge.todaypopup.core.domain.model.Area
import com.wedge.todaypopup.core.domain.model.Region
import com.wedge.todaypopup.core.navigation.navigator.TodayPopupNavigatorImpl
import com.wedge.todaypopup.core.ui.component.NavigationCloseBar
import com.wedge.todaypopup.core.ui.component.RoundedButton
import com.wedge.todaypopup.core.ui.theme.Body1
import com.wedge.todaypopup.core.ui.theme.Coral60
import com.wedge.todaypopup.core.ui.theme.Grey05
import com.wedge.todaypopup.core.ui.theme.Grey10
import com.wedge.todaypopup.core.ui.theme.Grey80
import com.wedge.todaypopup.core.ui.theme.Subtitle2
import com.wedge.todaypopup.core.ui.theme.White
import com.wedge.todaypopup.core.ui.util.clickableSingle

@Composable
fun LocationFilterScreen(
    modifier: Modifier = Modifier,
    navigator: TodayPopupNavigator = TodayPopupNavigatorImpl(),
    viewModel: LocationFilterViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.fetchRegionList()
        viewModel.fetchAreaList()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        LocationFilterContent(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            regionList = viewModel.regionList,
            areaList = viewModel.areaList,
            navigateUp = { navigator.navigateUp() },
            regionClick = { index -> viewModel.selectRegion(index) },
            areaClick = { index -> viewModel.selectArea(index) }
        )

        Box(
            Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .zIndex(1f)
        ) {
            RoundedButton(
                modifier = Modifier.fillMaxWidth(),
                text = "적용",
                textStyle = Subtitle2,
                textColor = White,
                roundDp = 8.dp,
                buttonColor = Coral60,
                horizontalPaddingDp = 16.dp,
                verticalPaddingDp = 10.dp
            ) {

            }
        }
    }

}

@Composable
private fun LocationFilterContent(
    modifier: Modifier = Modifier,
    regionList: List<Region>,
    areaList: List<Area>,
    navigateUp: () -> Unit,
    regionClick: (index: Int) -> Unit,
    areaClick: (index: Int) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        NavigationCloseBar(
            rightContent = {
                ResetButton(
                    reset = {

                    }
                )
            },
            closeButtonClick = {
                navigateUp()
            }
        )

        LocationLazyColumn(
            regionList = regionList,
            areaList = areaList,
            regionClick = regionClick,
            areaClick = areaClick
        )
    }
}

@Composable
private fun LocationLazyColumn(
    modifier: Modifier = Modifier,
    regionList: List<Region>,
    areaList: List<Area>,
    regionClick: (index: Int) -> Unit,
    areaClick: (index: Int) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            RegionListColumn(
                regionList = regionList,
                regionClick = regionClick
            )
        }

        Box(
            modifier = Modifier.weight(2f)
        ) {
            AreaListColumn(
                areaList = areaList,
                areaClick = areaClick
            )
        }
    }
}

@Composable
private fun RegionListColumn(
    modifier: Modifier = Modifier,
    regionList: List<Region>,
    regionClick: (index: Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .background(Grey10)
    ) {
        itemsIndexed(
            items = regionList,
            key = { _, region -> region.id }
        ) { index, region ->
            RegionTab(region = region) {
                regionClick(index)
            }
        }
    }
}

@Composable
private fun RegionTab(
    modifier: Modifier = Modifier,
    region: Region,
    regionClick: () -> Unit
) {
    val boxBgColor = if(region.isSelected) Grey05 else Color.Unspecified

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(boxBgColor)
            .padding(vertical = 16.dp, horizontal = 20.dp)
            .clickableSingle { regionClick() }
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = region.name,
            style = Subtitle2,
            color = Grey80,
        )
    }
}

@Composable
private fun AreaListColumn(
    modifier: Modifier = Modifier,
    areaList: List<Area>,
    areaClick: (index: Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
    ) {
        itemsIndexed(
            items = areaList,
            key = { _, area -> area.id }
        ) { index, area ->
            AreaTab(area = area) {
                areaClick(index)
            }
        }
    }
}

@Composable
private fun AreaTab(
    modifier: Modifier = Modifier,
    area: Area,
    tabSelected: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .clickableSingle {
                tabSelected()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .height(25.dp),
            text = area.name,
            style = Body1,
            color = Grey80,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        if (area.isSelected) {
            Spacer(modifier = Modifier.width(8.dp))

            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "check_icon",
                colorFilter = ColorFilter.tint(Coral60)
            )
        }
    }
}

@Composable
private fun ResetButton(
    modifier: Modifier = Modifier,
    reset: () -> Unit
) {
    Row(
        modifier = modifier
            .clickableSingle { reset() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_reset),
            contentDescription = "reset",
            colorFilter = ColorFilter.tint(Grey80)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(text = "초기화")
    }
}

@Preview
@Composable
private fun Preview_LocationFilterScreen() {
    LocationFilterScreen()
}