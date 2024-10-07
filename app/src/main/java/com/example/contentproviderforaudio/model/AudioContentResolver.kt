package com.example.contentproviderforaudio.model

import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.example.contentproviderforaudio.viewModels.AudioViewModel

class AudioContentResolver(context: Context) {

    val audioViewModel = AudioViewModel()

    val projection = arrayOf(

        MediaStore.Audio.Media.DISPLAY_NAME,
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.DURATION,
        MediaStore.Audio.Media.ARTIST,
        MediaStore.Audio.Media.TITLE
    )


    init {
        context.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        ).use { cursor->

            val nameColumn = cursor?.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)
            val idColumn = cursor?.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val durationColumn = cursor?.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
            val artistColumn = cursor?.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val titleColumn = cursor?.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)

            var audioList = mutableListOf<AudioDatas>()

            while (cursor?.moveToNext() == true){
                //val uri = uriColumn //sus
                val uri:Uri
                val diaplayName = cursor.getString(nameColumn!!)
                val id = cursor.getLong(idColumn!!)
                val duration = cursor.getInt(durationColumn!!)
                val artist = cursor.getString(artistColumn!!)
                val title = cursor.getString(titleColumn!!)


                uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,id)
                audioList.add(AudioDatas(uri.toString(),diaplayName,id,duration,artist,title))
            }

            audioViewModel.updateAudio(audioList)

        }
    }

    fun audioLists(){
        val audio by mutableStateOf(emptyList<AudioDatas>())

    }


}