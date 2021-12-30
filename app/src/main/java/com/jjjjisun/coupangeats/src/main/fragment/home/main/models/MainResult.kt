package com.jjjjisun.coupangeats.src.main.fragment.home.main.models

data class MainResult(
    val getEventsRes: List<MainGetEventsRe>,
    val getHomeEventRes: MainGetHomeEventRes,
    val getHotFranchisesRes: List<MainGetHotFranchisesRe>,
    val getIsSaleRes: List<MainGetIsSaleRe>,
    val getNewStoresRes: List<MainGetNewStoresRe>,

    //배열에 넣어야 하는 데이터
    val getOnlyEatsRes: List<MainGetOnlyEatsRe>
)