package io.quee.ktx.radix.tool.test.type

import io.quee.ktx.radix.tool.test.regex.KtxRegex

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
open class DefaultKtxRegex(
        private val regexValue: String,
        override val preProcess: Boolean
) : KtxRegex {
    override val regex = regexValue.toRegex()

    override fun String.isMatch() = regex.matches(this)
    override fun String.replace(transformer: (MatchResult) -> String): String {
        require(isMatch()) {
            "Invalid input, $this didn't match $regexValue."
        }
        return ""
    }
}