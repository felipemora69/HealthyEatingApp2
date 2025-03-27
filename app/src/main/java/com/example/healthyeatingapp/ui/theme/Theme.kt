package com.example.healthyeatingapp.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

private val LightThemeColors = lightColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    background = BackgroundColor,
    surface = TertiaryColor
)

@Composable
fun HealthyEatingAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightThemeColors,
        typography = Typography,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HealthyEatingAppTheme {
        // Your app UI goes here
    }
}