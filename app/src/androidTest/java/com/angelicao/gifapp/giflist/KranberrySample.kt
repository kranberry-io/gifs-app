package com.angelicao.gifapp.giflist

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import io.kranberry.KranberryRules
import io.kranberry.ScreenshotHandler.takeScreenshot
import io.kranberry.environment.DeviceHandler
import io.kranberry.environment.DeviceHandler.APP_PACKAGE
import io.kranberry.environment.TestHandler.device
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 21)
class KranberrySample {

    @Rule
    @JvmField
    val testRule = KranberryRules()

    @Test
    fun openGoogleChrome() {
        DeviceHandler.start(APP_PACKAGE)
        takeScreenshot()
    }
}