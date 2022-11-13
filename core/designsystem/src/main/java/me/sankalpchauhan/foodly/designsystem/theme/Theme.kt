package me.sankalpchauhan.foodly.designsystem.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    content: @Composable () -> Unit
) = AppTheme(
    darkTheme = darkTheme,
    androidTheme = androidTheme,
    disableDynamicTheming = true,
    content = content
)

val LightDefaultTheme = lightColorScheme(
    primary = Red,
    surface = LightBackground,
    onBackground = Red,
)

val DarkDefaultTheme = darkColorScheme(
    primary = Color.Black,
    surface = DarkPurpleGray10,
)

val LightAndroidBackgroundTheme = BackgroundTheme(color = LightBackground)
val DarkAndroidBackgroundTheme = BackgroundTheme(color = Color.Black)



@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
private fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

@Composable
internal fun AppTheme(
    darkTheme: Boolean = isTraceInProgress(),
    androidTheme:Boolean = false,
    disableDynamicTheming:Boolean,
    content: @Composable () -> Unit
){
    val colorScheme = if(androidTheme){
        if(darkTheme) DarkDefaultTheme else LightDefaultTheme
    } else if (!disableDynamicTheming && supportsDynamicTheming()) {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (darkTheme) DarkDefaultTheme else LightDefaultTheme
    }
    val gradientColors = GradientColors()
    val defaultBackgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
        tonalElevation = 2.dp
    )
    val backgroundTheme = if (androidTheme) {
        if (darkTheme) DarkAndroidBackgroundTheme else LightAndroidBackgroundTheme
    } else {
        defaultBackgroundTheme
    }
    CompositionLocalProvider(
        LocalGradientColors provides gradientColors,
        LocalBackgroundTheme provides backgroundTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }

}