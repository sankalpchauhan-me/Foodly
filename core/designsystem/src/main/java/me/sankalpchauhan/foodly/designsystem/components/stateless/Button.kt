package me.sankalpchauhan.foodly.designsystem.components.stateless

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.sankalpchauhan.foodly.designsystem.icon.IconAdapter
import me.sankalpchauhan.foodly.designsystem.theme.NoRippleTheme

@Composable
fun AppPrimaryFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    normal:Boolean = true,
    colors: ButtonColors = AppButtonDefaults.filledPrimaryButtonColors(),
    contentPadding: PaddingValues = AppButtonDefaults.buttonContentPadding(small = small),
    content: @Composable RowScope.() -> Unit
){
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()
    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        modifier = if (small) {
            modifier.heightIn(min = AppButtonDefaults.SmallButtonHeight)
        } else if(normal) {
            modifier.heightIn(min = AppButtonDefaults.NormalButtonHeight)
        } else{ modifier },
        shape = RoundedCornerShape(20.dp),
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        content = {
            ProvideTextStyle(value = MaterialTheme.typography.labelSmall) {
                content()
            }
        }
    )
}

@Composable
fun AppPrimaryFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    colors: ButtonColors = AppButtonDefaults.filledPrimaryButtonColors(),
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    AppPrimaryFilledButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small = small,
        colors = colors,
        contentPadding = AppButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        )
    ) {
        AppButtonContent(
            text = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
fun AppSecondaryFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    normal:Boolean = true,
    colors: ButtonColors = AppButtonDefaults.filledSecondaryButtonColors(),
    contentPadding: PaddingValues = AppButtonDefaults.buttonContentPadding(small = small),
    content: @Composable RowScope.() -> Unit
){
    AppPrimaryFilledButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small  = small,
        normal = normal,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun AppImageButton(
    onClick: () -> Unit,
    modifier: Modifier,
    icon: IconAdapter,
    shape: Shape = RoundedCornerShape(10.dp),
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.surface
){
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        elevation = elevation(defaultElevation = 0.dp, pressedElevation = 0.dp),
        containerColor = containerColor,
        contentColor = contentColor,
        content = {
            if (icon is IconAdapter.ImageVectorIcon) {
                Icon(
                    imageVector = icon.imageVector,
                    contentDescription = null,
                )
            } else if (icon is IconAdapter.DrawableResourceIcon) {
                Icon(
                    painterResource(id = icon.id),
                    contentDescription = null,
                )
            }
        }
    )
}

@Composable
fun CircularImageButton(
    onClick: () -> Unit,
    icon:IconAdapter,
    modifier: Modifier,
    containerColor: Color = MaterialTheme.colorScheme.tertiary,
    contentColor: Color = MaterialTheme.colorScheme.surface
){
    AppImageButton(
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        shape = RoundedCornerShape(100.dp),
        containerColor = containerColor,
        contentColor = contentColor
    )
}

@Composable
fun AppSecondaryFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    normal:Boolean = true,
    colors: ButtonColors = AppButtonDefaults.filledSecondaryButtonColors(),
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
){
    AppSecondaryFilledButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small  = small,
        normal = normal,
        colors = colors,
        contentPadding = AppButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        ),
    )
    {
        AppButtonContent(
            text = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
fun AppTertiaryFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    normal:Boolean = true,
    colors: ButtonColors = AppButtonDefaults.filledTertiaryButtonColors(),
    contentPadding: PaddingValues = AppButtonDefaults.buttonContentPadding(small = small),
    content: @Composable RowScope.() -> Unit
){
    AppPrimaryFilledButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small  = small,
        normal = normal,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun AppTertiaryFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    normal:Boolean = true,
    colors: ButtonColors = AppButtonDefaults.filledTertiaryButtonColors(),
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
){
    AppSecondaryFilledButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small  = small,
        normal = normal,
        colors = colors,
        contentPadding = AppButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        ),
    )
    {
        AppButtonContent(
            text = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    colors: ButtonColors = AppButtonDefaults.textButtonColors(),
    contentPadding: PaddingValues = AppButtonDefaults.buttonContentPadding(small = small),
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = if (small) {
            modifier.heightIn(min = AppButtonDefaults.SmallButtonHeight)
        } else {
            modifier
        },
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        content = {
            ProvideTextStyle(value = MaterialTheme.typography.labelSmall) {
                content()
            }
        }
    )
}

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    colors: ButtonColors = AppButtonDefaults.textButtonColors(),
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    AppTextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small = small,
        colors = colors,
        contentPadding = AppButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        )
    ) {
        AppButtonContent(
            text = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
fun AppFloatingActionButton(
    onClick: () -> Unit,
    iconAdapter: IconAdapter
){
    FloatingActionButton(onClick = onClick, shape = RoundedCornerShape(50),
        modifier = Modifier.shadow(
            30.dp,
            clip = false,
            shape = RoundedCornerShape(10.dp),
            ambientColor = MaterialTheme.colorScheme.primary,
            spotColor = MaterialTheme.colorScheme.primary),
    ){
        (iconAdapter as? IconAdapter.ImageVectorIcon)?.let {
            Icon(imageVector = iconAdapter.imageVector, contentDescription = null)
        }
        (iconAdapter as? IconAdapter.DrawableResourceIcon)?.let {
            Icon(painter = painterResource(iconAdapter.id), contentDescription = null)
        }
    }
}

@Composable
fun AppExtendedFloatingActionButton(
    onClick: () -> Unit,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled:Boolean = true
){
    CompositionLocalProvider(
        LocalRippleTheme provides
            if (enabled)  LocalRippleTheme.current else NoRippleTheme
    ) {
        ExtendedFloatingActionButton(
            onClick = onClick, shape = RoundedCornerShape(50),
            elevation = elevation(0.dp, 0.dp),
            modifier = Modifier.shadow(
                20.dp,
                clip = false,
                shape = RoundedCornerShape(10.dp),
                ambientColor = MaterialTheme.colorScheme.primary,
                spotColor = MaterialTheme.colorScheme.primary
            ).width(214.dp).height(47.dp),
        ) {
            AppButtonContent(
                text = text,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon
            )
        }
    }
}

@Composable
private fun RowScope.AppButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?
) {
    Row(verticalAlignment = Alignment.CenterVertically){
        Box(modifier = Modifier.weight(1f).align(alignment = Alignment.CenterVertically), contentAlignment = Alignment.CenterStart) {
            if (leadingIcon != null) {
                leadingIcon()
            }
        }
        Box(
            Modifier.weight(2f).align(alignment = Alignment.CenterVertically), contentAlignment = Alignment.Center
        ) {
            text()
        }
        Box(modifier = Modifier.weight(1f).align(alignment = Alignment.CenterVertically), contentAlignment = Alignment.CenterEnd){
            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
}

object AppButtonDefaults{
    val SmallButtonHeight = 32.dp
    val NormalButtonHeight = 60.dp
    const val DisabledButtonContainerAlpha = 0.12f
    const val DisabledButtonContentAlpha = 0.38f
    val ButtonHorizontalPadding = 24.dp
    val ButtonHorizontalIconPadding = 16.dp
    val ButtonVerticalPadding = 8.dp
    val SmallButtonHorizontalPadding = 16.dp
    val SmallButtonHorizontalIconPadding = 12.dp
    val SmallButtonVerticalPadding = 7.dp
    val ButtonContentSpacing = 8.dp
    val ButtonIconSize = 18.dp
    fun imageButtonContentPadding(
    ): PaddingValues {
        return PaddingValues(
            start = ButtonHorizontalPadding,
            top = ButtonHorizontalPadding,
            end = ButtonHorizontalPadding,
            bottom = ButtonHorizontalPadding
        )
    }
    fun buttonContentPadding(
        small: Boolean,
        leadingIcon: Boolean = false,
        trailingIcon: Boolean = false
    ): PaddingValues {
        return PaddingValues(
            start = when {
                small && leadingIcon -> SmallButtonHorizontalIconPadding
                small -> SmallButtonHorizontalPadding
                leadingIcon -> ButtonHorizontalIconPadding
                else -> ButtonHorizontalPadding
            },
            top = if (small) SmallButtonVerticalPadding else ButtonVerticalPadding,
            end = when {
                small && trailingIcon -> SmallButtonHorizontalIconPadding
                small -> SmallButtonHorizontalPadding
                trailingIcon -> ButtonHorizontalIconPadding
                else -> ButtonHorizontalPadding
            },
            bottom = if (small) SmallButtonVerticalPadding else ButtonVerticalPadding
        )
    }
    @Composable
    fun filledPrimaryButtonColors(
        containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContainerAlpha
        ),
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContentAlpha
        )
    ) = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun filledSecondaryButtonColors(
        containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor: Color = MaterialTheme.colorScheme.onSecondary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContainerAlpha
        ),
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContentAlpha
        )
    ) = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun filledTertiaryButtonColors(
        containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor: Color = MaterialTheme.colorScheme.onTertiary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContainerAlpha
        ),
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContentAlpha
        )
    ) = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )
    @Composable
    fun outlinedButtonBorder(
        enabled: Boolean,
        width: Dp = 1.dp,
        color: Color = MaterialTheme.colorScheme.onBackground,
        disabledColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContainerAlpha
        )
    ): BorderStroke = BorderStroke(
        width = width,
        color = if (enabled) color else disabledColor
    )
    @Composable
    fun outlinedButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        disabledContainerColor: Color = Color.Transparent,
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContentAlpha
        )
    ) = ButtonDefaults.outlinedButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )
    @Composable
    fun textButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.onSecondary,
        disabledContainerColor: Color = Color.Transparent,
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContentAlpha
        )
    ) = ButtonDefaults.textButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )
}