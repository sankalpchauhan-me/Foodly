package me.sankalpchauhan.foodly_catalouge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import me.sankalpchauhan.foodly.designsystem.components.stateful.quantitybutton.QuantityWidget
import me.sankalpchauhan.foodly.designsystem.components.stateless.AppExtendedFloatingActionButton
import me.sankalpchauhan.foodly.designsystem.components.stateless.AppFloatingActionButton
import me.sankalpchauhan.foodly.designsystem.components.stateless.AppImageButton
import me.sankalpchauhan.foodly.designsystem.components.stateless.AppPrimaryFilledButton
import me.sankalpchauhan.foodly.designsystem.components.stateless.AppSecondaryFilledButton
import me.sankalpchauhan.foodly.designsystem.components.stateless.AppTertiaryFilledButton
import me.sankalpchauhan.foodly.designsystem.components.stateless.AppTextButton
import me.sankalpchauhan.foodly.designsystem.components.stateless.CircularImageButton
import me.sankalpchauhan.foodly.designsystem.icon.AppIcons
import me.sankalpchauhan.foodly.designsystem.icon.IconAdapter
import me.sankalpchauhan.foodly.designsystem.theme.AppTextStyles
import me.sankalpchauhan.foodly.designsystem.theme.AppTheme
import me.sankalpchauhan.ui.PhoneUiModePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCatalog() {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    AppTheme{
        Surface{
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                item {
                    Text(
                        text = "App Catalog",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
                item { Text("Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(mainAxisSpacing = 16.dp) {
                        AppPrimaryFilledButton(
                            onClick = {},
                            modifier = Modifier.fillMaxSize(),
                            text = {Text(text = "Test", style = MaterialTheme.typography.titleLarge)}
                        )
                        Box(modifier = Modifier.padding(4.dp))
                        AppTertiaryFilledButton(
                            onClick = {},
                            modifier = Modifier.fillMaxSize(),
                            text = {Text(text = "Icon Button", style = MaterialTheme.typography.titleMedium)},
                            trailingIcon = {Icon(imageVector = AppIcons.ChevronRight, contentDescription = null)}
                        )
                        Box(modifier = Modifier.padding(4.dp))
                        AppSecondaryFilledButton(
                            onClick = {},
                            modifier = Modifier.fillMaxSize(),
                            text = {Text(text = "Skip for now", style = MaterialTheme.typography.titleMedium)}
                        )
                        Box(modifier = Modifier.padding(4.dp))
                        AppTextButton(
                            onClick = {},
                            modifier = Modifier.fillMaxSize(),
                            text = {Text(text = "See details", style = AppTextStyles.tsRegular16Underlined)}
                        )
                        Box(modifier = Modifier.padding(4.dp))
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                            AppFloatingActionButton(
                                onClick = {},
                                iconAdapter = IconAdapter.ImageVectorIcon(Icons.Filled.Map)
                            )
                        }
                        Box(modifier = Modifier.padding(4.dp))
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                            AppImageButton(
                                onClick = {},
                                icon = IconAdapter.ImageVectorIcon(Icons.Filled.Map),
                                modifier = Modifier.clipToBounds()
                            )
                        }
                        Box(modifier = Modifier.padding(4.dp))
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                            CircularImageButton(
                                onClick = {},
                                icon = IconAdapter.ImageVectorIcon(Icons.Filled.Sort),
                                modifier = Modifier
                                    .height(34.dp)
                                    .width(34.dp),
                                containerColor = Color.Black
                            )
                        }
                        Box(modifier = Modifier.padding(4.dp))
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                            AppExtendedFloatingActionButton(
                                onClick = {},
                                text = {Text(text = "2 Promotional availaible", style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)},
                                trailingIcon = {Icon(imageVector = AppIcons.ChevronRight, contentDescription = null)}
                            )
                        }
                        Box(modifier = Modifier.padding(8.dp))
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                            QuantityWidget(
                                enabled = true,
                                modifier = Modifier.width((configuration.screenWidthDp/2).dp),
                                onAddition = {},
                                onDeletion = {})
                        }
                    }
                }
            }

        }

    }
}

@PhoneUiModePreview
@Composable
fun FoodlyCatalog(){
    AppCatalog()
}