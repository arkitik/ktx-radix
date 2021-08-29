package io.arkitik.ktx.radix.develop.shared.exception

import io.arkitik.ktx.radix.develop.shared.error.ErrorResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
abstract class BaseException(
    val error: ErrorResponse,
) : RuntimeException() {
    override val message: String?
        get() = toString()

    override fun toString(): String {
        return "BaseException{" +
                "error=" + error +
                '}'
    }

}