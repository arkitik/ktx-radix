package io.arkitik.ktx.radix.develop.usecase.validation.func

import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest


/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface UseCaseValidator {
    fun <RQ : UseCaseRequest> RQ.validate()
}