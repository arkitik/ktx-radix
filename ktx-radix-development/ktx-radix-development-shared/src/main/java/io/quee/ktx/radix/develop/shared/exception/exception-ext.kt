package io.quee.ktx.radix.develop.shared.exception

import io.quee.ktx.radix.develop.shared.error.Error

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 10, **Wed February, 2021**
 * Project *ktx-radix* [Quee.IO]
 */

infix fun <R> R?.notAcceptable(error: Error) =
    this ?: throw NotAcceptableException(error)

infix fun <R> R?.notAuthorized(error: Error) =
    this ?: throw NotAuthorizedException(error)

infix fun <R> R?.resourceNotFound(error: Error) =
    this ?: throw ResourceNotFoundException(error)

infix fun <R> R?.internalError(error: Error) =
    this ?: throw InternalException(error)

infix fun <R> R?.badRequest(error: Error) =
    badRequest(listOf(error))

infix fun <R> R?.badRequest(errors: List<Error>) =
    this ?: throw BadRequestException(errors)