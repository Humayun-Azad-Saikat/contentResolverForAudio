package com.example.contentproviderforaudio.model

import java.net.URI

data class AudioDatas(
    val uri: String,
    val dispalyName:String,
    val id:Long,
    val duration:Int,
    val artist:String,
    val title:String
)
