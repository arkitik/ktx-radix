package io.quee.ktx.radix.tool.test.dsl

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.quee.ktx.radix.tool.test.KtxTestingTool
import io.quee.ktx.radix.tool.test.dto.TestCase
import io.quee.ktx.radix.tool.test.dto.TestClassData
import org.junit.jupiter.api.DynamicTest
import kotlin.reflect.KClass

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
val gson = Gson()

fun <RS : Any> KtxTestingTool.run(
    jsonObject: JsonObject,
    clazz: KClass<RS>,
    successCall: (TestCase, RS?) -> Unit,
    failCall: (TestCase, Throwable) -> Unit,
): List<DynamicTest> {
    return run(
        jsonObject.toTestData(),
        clazz,
        successCall,
        failCall
    )
}

fun JsonObject.toTestData(): TestClassData = gson parse this