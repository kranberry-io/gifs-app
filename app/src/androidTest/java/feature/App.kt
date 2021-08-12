package feature

import androidx.test.uiautomator.UiDevice
import io.kranberry.environment.DeviceHandler
import io.kranberry.outputs.ScreenshotHandler
import io.kranberry.ui.BaseUi
import io.kranberry.ui.elementIsPresentByTextContains
import junit.framework.TestCase.assertTrue

open class App(device: UiDevice) : BaseUi(device) {

    open fun open(): Home {
        DeviceHandler.start(DeviceHandler.APP_PACKAGE)
        ScreenshotHandler.takeScreenshot()
        assertTrue(elementIsPresentByTextContains("Gif Application"))
        return Home(device)
    }
}