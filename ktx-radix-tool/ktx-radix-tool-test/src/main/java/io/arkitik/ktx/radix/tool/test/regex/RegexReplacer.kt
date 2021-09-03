package io.arkitik.ktx.radix.tool.test.regex

import io.arkitik.ktx.radix.tool.test.dto.TestClassData

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface RegexReplacer {
    fun String.replace(): TestClassData
}