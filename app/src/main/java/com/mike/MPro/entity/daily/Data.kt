package com.mike.MPro.entity.daily

data class Data(
    val actionUrl: String,
    val ad: Boolean,
    val adTrack: Any,
    val author: Author,
    val autoPlay: Boolean,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val count: Int,
    val cover: Cover,
    val dataType: String,
    val date: Long,
    val description: Any,
    val descriptionEditor: String,
    val descriptionPgc: Any,
    val duration: Int,
    val expert: Boolean,
    val favoriteAdTrack: Any,
    val follow: Any,
    val footer: Any,
    val haveReward: Boolean,
    val header: Header,
    val icon: String,
    val iconType: String,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val ifNewest: Boolean,
    val ifPgc: Boolean,
    val ifShowNotificationIcon: Boolean,
    val image: String,
    val itemList: List<ItemX>,
    val label: Any,
    val labelList: Any,
    val lastViewTime: Any,
    val library: String,
    val medalIcon: Boolean,
    val newestEndTime: Any,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val promotion: Any,
    val provider: Provider,
    val reallyCollected: Boolean,
    val recallSource: Any,
    val releaseTime: Long,
    val remark: Any,
    val resourceType: String,
    val rightText: String,
    val searchWeight: Int,
    val shade: Boolean,
    val shareAdTrack: Any,
    val slogan: Any,
    val src: Any,
    val subTitle: Any,
    val subtitles: List<Any>,
    val switchStatus: Boolean,
    val tags: List<Tag>,
    val text: String,
    val thumbPlayUrl: Any,
    val title: String,
    val titlePgc: Any,
    val type: String,
    val uid: Int,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl
)