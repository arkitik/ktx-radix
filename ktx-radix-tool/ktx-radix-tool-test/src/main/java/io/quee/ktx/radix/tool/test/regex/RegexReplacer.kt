package io.quee.ktx.radix.tool.test.regex

import io.quee.ktx.radix.tool.test.dto.TestClassData

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
interface RegexReplacer {
    fun String.replace(): TestClassData
}