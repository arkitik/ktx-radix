package io.quee.ktx.radix.develop.usecase

import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
@FunctionalInterface
interface CommandUseCase<RQ : UseCaseRequest> {
    fun RQ.execute()
}