package io.quee.ktx.radix.tool.test.function

import java.io.InputStream
import kotlin.reflect.KClass

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
interface DataParser {
    fun <T : Any> String.parse(clazz: KClass<T>): T
    fun <T : Any> InputStream.parse(clazz: KClass<T>): T
    fun <T : Any> T.write(): String
}