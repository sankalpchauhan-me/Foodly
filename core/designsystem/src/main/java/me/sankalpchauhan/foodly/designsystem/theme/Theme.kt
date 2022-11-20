package me.sankalpchauhan.foodly.designsystem.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
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
    primaryContainer = Red,
    onPrimary = Color.White,
    surface = Color.White,
    onBackground = Red,
    secondaryContainer = SecondaryButtonContainer,
    onSecondary = Black,
    tertiaryContainer = Color.Black,
    onTertiary = Color.White,
)

val DarkDefaultTheme = darkColorScheme(
    primary = Red,
    primaryContainer = Maroon,
    onPrimary = Color.Black,
    surface = DarkPurpleGray10,
    secondaryContainer = Orange30,
    onSecondary = Orange80,
    onBackground = DarkPurpleGray90,
    tertiaryContainer = Color.White,
    onTertiary = Color.Black
)

val LightAndroidBackgroundTheme = BackgroundTheme(color = Color.White)
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
        tonalElevation = 0.dp
    )
    val backgroundTheme = if (androidTheme) {
        if (darkTheme) DarkAndroidBackgroundTheme else LightAndroidBackgroundTheme
    } else {
        defaultBackgroundTheme
    }
    CompositionLocalProvider(
        LocalGradientColors provides gradientColors,
        LocalBackgroundTheme provides backgroundTheme,
        LocalRippleTheme provides AppRippleTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }

}

private object AppRippleTheme : RippleTheme {
    // Here you should return the ripple color you want
    // and not use the defaultRippleColor extension on RippleTheme.
    // Using that will override the ripple color set in DarkMode
    // or when you set light parameter to false
    @Composable
    override fun defaultColor(): Color = MaterialTheme.colorScheme.primary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Color.Black,
        lightTheme = !isSystemInDarkTheme()
    )
}
 object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}