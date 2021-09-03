package io.arkitik.ktx.radix.develop.shared.exception

import io.arkitik.ktx.radix.develop.shared.error.ErrorResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
class NotAuthorizedException(
    error: ErrorResponse,
) : BaseException(error)