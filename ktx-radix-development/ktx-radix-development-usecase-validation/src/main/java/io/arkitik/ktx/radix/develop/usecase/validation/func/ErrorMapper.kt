package io.arkitik.ktx.radix.develop.usecase.validation.func

import io.arkitik.ktx.radix.develop.shared.error.ErrorResponse
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest
import javax.validation.ConstraintViolation

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface ErrorMapper {
    fun <RQ : UseCaseRequest> ConstraintViolation<RQ>.mapToError(): ErrorResponse
}