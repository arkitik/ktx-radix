package io.quee.ktx.radix.develop.shared.error

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
data class Error(
    override val code: String?,
    override val message: String?,
) : ErrorResponse


interface ErrorResponse {
    val code: String?
    val message: String?
}