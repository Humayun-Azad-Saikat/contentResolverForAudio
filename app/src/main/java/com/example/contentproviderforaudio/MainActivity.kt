package com.example.contentproviderforaudio

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.contentproviderforaudio.audiopacks.Media3
import com.example.contentproviderforaudio.model.AudioContentResolver
import com.example.contentproviderforaudio.ui.theme.ContentProviderForAudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val audioContentResolver = AudioContentResolver(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_MEDIA_AUDIO),
                0
            )
        }

        setContent {
            ContentProviderForAudioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {

                    //media3 class object
                    val media3 = Media3(this)

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val viewmodel = audioContentResolver.audioViewModel

                        items(viewmodel.audios){

                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("${it.title}",
                                    modifier = Modifier.clickable {
                                        media3.PlayMusic("${it.uri}")
                                    }
                                )
                                //Text("${it.dispalyName}")
                                Text("${it.duration/1000}")
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