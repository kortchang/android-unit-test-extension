package kort.tool.test.extension

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.*

/**
 * Created by Kort on 2019-07-04.
 */
@ExperimentalCoroutinesApi
class TestCoroutineExtension : Extension, BeforeAllCallback, AfterAllCallback {
    private val testDispatcher = TestCoroutineDispatcher()

    override fun beforeAll(context: ExtensionContext?) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun afterAll(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }
}