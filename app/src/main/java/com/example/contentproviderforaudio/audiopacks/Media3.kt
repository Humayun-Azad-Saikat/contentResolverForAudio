package com.example.contentproviderforaudio.audiopacks

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class Media3(private val context: Context) {

   // @Composable
    fun PlayMusic(uri: String){

//        val player = remember {
//            ExoPlayer.Builder(context).build().apply {
//                val mediaItem = MediaItem.fromUri(uri)
//                addMediaItem(mediaItem)
//                prepare()
//                play()
//            }
//        }

        val player:ExoPlayer = ExoPlayer.Builder(context).build().apply {
                val mediaItem = MediaItem.fromUri(uri)
                addMediaItem(mediaItem)
                prepare()
                play()
            }



//            DisposableEffect(player) {
//                onDispose {
//                    player.release()
//                }
//            }
        }

    }
