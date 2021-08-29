package io.arkitik.ktx.radix.develop.usecase

import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
@FunctionalInterface
interface CommandUseCase<RQ : UseCaseRequest> {
    fun RQ.execute()
}