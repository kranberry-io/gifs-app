package feature

import androidx.test.uiautomator.UiDevice
import io.kranberry.outputs.ScreenshotHandler.takeScreenshot
import io.kranberry.ui.BaseUi
import io.kranberry.ui.elementIsPresentById

class Home(device: UiDevice) : BaseUi(device) {

    fun shouldSeeShareOption(): Home {
        assert(elementIsPresentById("share"))
        takeScreenshot()
        return this
    }
}