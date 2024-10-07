package com.example.contentproviderforaudio

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.provider.MediaStore.Audio
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import com.example.contentproviderforaudio.model.AudioContentResolver
import com.example.contentproviderforaudio.model.AudioDatas
import com.example.contentproviderforaudio.ui.theme.ContentProviderForAudioTheme
import com.example.contentproviderforaudio.viewModels.AudioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val audioContentResolver = AudioContentResolver(this)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_MEDIA_AUDIO),
            0
        )

        setContent {
            ContentProviderForAudioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    //val audioContentResolver = AudioContentResolver(this)
                    //val audioDatas = listOf<AudioDatas>()
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val viewmodel = audioContentResolver.audioViewModel

                      if()
                        items(viewmodel.audios){

                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("${it.title}")
                                Text("${it.dispalyName}")
                                Text("${it.duration}")
                                Text("${it.uri}")
                            }
                            HorizontalDivider(modifier = Modifier.fillMaxWidth(),1.dp)
                        }
                    }

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContentProviderForAudioTheme {

    }
}