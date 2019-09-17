package kort.tool.test.extension

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

/**
 * Created by Kort on 2019-07-13.
 */
class TestKoinExtension(private val module: Module) : BeforeAllCallback, AfterAllCallback {
    override fun beforeAll(context: ExtensionContext?) {
        startKoin {
            modules(module)
        }
    }

    override fun afterAll(context: ExtensionContext?) {
        stopKoin()
    }
}