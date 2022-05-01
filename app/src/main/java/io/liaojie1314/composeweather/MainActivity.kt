package io.liaojie1314.composeweather

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.liaojie1314.composeweather.ui.theme.ComposeWeatherTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transparentStatusBar(window)
        setContent {
            ComposeWeatherTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    WeatherView()
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    ComposeWeatherTheme {
        MyApp()
    }
}

private fun transparentStatusBar(window: Window) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    val option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    val vis = window.decorView.systemUiVisibility
    window.decorView.systemUiVisibility = option or vis
    window.statusBarColor = Color.TRANSPARENT
}
