package me.sankalpchauhan.foodly.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import me.sankalpchauhan.foodly.designsystem.R

val sfProTextFamily = FontFamily(
    Font(R.font.sf_pro_text_regular, FontWeight.W400),
    Font(R.font.sf_pro_text_bold, FontWeight.W700),
    Font(R.font.sf_pro_text_heavy, FontWeight.W800),
    Font(R.font.sf_pro_text_light, FontWeight.W300),
    Font(R.font.sf_pro_text_medium, FontWeight.W500),
    Font(R.font.sf_pro_text_semibold, FontWeight.W600)
)

object AppTextStyles{
    val tsRegular16Underlined:TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        textDecoration = TextDecoration.Underline
    )
}

internal val AppTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.W700,
        fontFamily = sfProTextFamily,
        fontSize = 20.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.W700,
        fontFamily = sfProTextFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.W500,
        fontFamily = sfProTextFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontFamily = sfProTextFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.W500,
        fontSize = 10.sp,
        lineHeight = 16.sp
    )
)
