package io.quee.ktx.radix.develop.shared.ext

import io.quee.ktx.radix.develop.shared.error.Error
import io.quee.ktx.radix.develop.shared.exception.*

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
fun Error.notFound() = ResourceNotFoundException(this)

fun Error.notAuthorized() = NotAuthorizedException(this)

fun Error.notAcceptable() = NotAcceptableException(this)

fun Error.internal() = InternalException(this)

fun Error.badRequest() = listOf(this).badRequest()

fun List<Error>.badRequest() = BadRequestException(this)