package com.example.scaler_task.pojo

data class Videos(
    val id: Int,
    val image: String,
    var isPlaying:Boolean,
    var playedCount:Int,
    val video_files: List<VideoFiles>
)