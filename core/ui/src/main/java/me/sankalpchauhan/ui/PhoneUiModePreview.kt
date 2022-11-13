package me.sankalpchauhan.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview


@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480", uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class PhoneUiModePreview
