package io.quee.ktx.radix.develop.shared.ext

import io.quee.ktx.radix.develop.shared.error.ErrorResponse
import io.quee.ktx.radix.develop.shared.exception.BadRequestException

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 10, **Wed February, 2021**
 * Project *ktx-radix* [https://quee.io]
 */

infix fun <R> R?.notAcceptable(error: ErrorResponse) =
    this ?: throw error.notAcceptable()

infix fun <R> R?.unprocessableEntity(error: ErrorResponse) =
    this ?: throw error.unprocessableEntity()

infix fun <R> R?.notAuthorized(error: ErrorResponse) =
    this ?: throw error.notAuthorized()

infix fun <R> R?.resourceNotFound(error: ErrorResponse) =
    this ?: throw error.notFound()

infix fun <R> R?.internalError(error: ErrorResponse) =
    this ?: throw error.internal()

infix fun <R> R?.badRequest(error: ErrorResponse) =
    badRequest(listOf(error))

infix fun <R> R?.badRequest(errors: List<ErrorResponse>) =
    this ?: throw BadRequestException(errors)