package com.example.contentproviderforaudio.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.contentproviderforaudio.model.AudioContentResolver
import com.example.contentproviderforaudio.model.AudioDatas

class AudioViewModel():ViewModel() {

    var audios by mutableStateOf(emptyList<AudioDatas>())
        private set



    fun updateAudio(audio:List<AudioDatas>){
        this.audios = audio
    }

}