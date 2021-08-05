package io.quee.ktx.radix.tool.test.processor

import io.quee.ktx.radix.tool.test.dto.TestCase
import kotlin.reflect.KClass

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
interface Processor {
    fun <RS : Any> process(
        testCase: TestCase,
        clazz: KClass<RS>,
        successCall: (TestCase, RS?) -> Unit,
        failCall: (TestCase, Throwable) -> Unit,
    )
}