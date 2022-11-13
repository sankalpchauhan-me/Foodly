package me.sankalpchauhan.foodly_catalouge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import me.sankalpchauhan.foodly.designsystem.components.AppFloatingActionButton
import me.sankalpchauhan.foodly.designsystem.components.AppPrimaryFilledButton
import me.sankalpchauhan.foodly.designsystem.components.AppSecondaryFilledButton
import me.sankalpchauhan.foodly.designsystem.components.AppTertiaryFilledButton
import me.sankalpchauhan.foodly.designsystem.components.AppTextButton
import me.sankalpchauhan.foodly.designsystem.icon.AppIcons
import me.sankalpchauhan.foodly.designsystem.icon.IconAdapter
import me.sankalpchauhan.foodly.designsystem.theme.AppTextStyles
import me.sankalpchauhan.foodly.designsystem.theme.AppTheme
import me.sankalpchauhan.ui.PhoneUiModePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCatalog() {
    val context = LocalContext.current
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