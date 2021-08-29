package io.arkitik.ktx.radix.develop.usecase.validation

import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.ktx.radix.develop.usecase.validation.func.UseCaseValidator

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */

infix fun <RQ : UseCaseRequest> UseCaseValidator.validate(request: RQ) = request.validate()