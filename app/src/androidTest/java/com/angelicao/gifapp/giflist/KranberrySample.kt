package com.angelicao.gifapp.giflist

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import feature.App
import io.kranberry.KranberryRules
import io.kranberry.environment.TestHandler.device
import io.kranberry.log.Log
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
    fun openGifApp() {
        Log.alert("Hello World")
        App(device)
            .open()
            .shouldSeeShareOption()
    }
}