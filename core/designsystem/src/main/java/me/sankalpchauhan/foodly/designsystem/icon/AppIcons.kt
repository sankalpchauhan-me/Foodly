package me.sankalpchauhan.foodly.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.ui.graphics.vector.ImageVector
import me.sankalpchauhan.foodly.designsystem.R

object AppIcons {
    val ChevronRightDrawable = R.drawable.chevron_right
    val ChevronRight = Icons.Filled.ChevronRight
}

sealed class IconAdapter {
    data class ImageVectorIcon(val imageVector: ImageVector) : IconAdapter()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : IconAdapter()
}