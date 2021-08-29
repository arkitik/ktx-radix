package io.arkitik.ktx.radix.tool.test.regex

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface KtxRegex {
    val regex: Regex
    val preProcess: Boolean

    fun String.isMatch(): Boolean
    fun String.replace(transformer: (MatchResult) -> String): String
}