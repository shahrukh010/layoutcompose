package com.code.android_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.code.android_layout.components.HomeScreen
import com.code.android_layout.components.SearchBar
import com.code.android_layout.ui.theme.AndroidlayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidlayoutTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen();
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidlayoutTheme {
        HomeScreen();
    }
}
