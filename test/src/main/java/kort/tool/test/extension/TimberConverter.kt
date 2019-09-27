package kort.tool.test.extension

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.slot
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import timber.log.Timber

/**
 * Created by Kort on 2019/9/27.
 */
class TimberConverter : BeforeEachCallback {
    override fun beforeEach(context: ExtensionContext?) {
        mockkStatic(Timber::class)
        val slot = slot<String>()

        every { Timber.d(capture(slot)) } answers { println(slot.captured) }
    }
}