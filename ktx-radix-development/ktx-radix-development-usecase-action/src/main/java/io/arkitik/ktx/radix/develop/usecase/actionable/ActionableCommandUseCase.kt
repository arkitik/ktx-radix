package io.arkitik.ktx.radix.develop.usecase.actionable

import io.arkitik.ktx.radix.develop.usecase.CommandUseCase
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
abstract class ActionableCommandUseCase<RQ : UseCaseRequest> : CommandUseCase<RQ>, Actionable<RQ, Unit> {
    final override fun RQ.execute() =
        with(this) {
            before()
            after(doExecute())
        }

    abstract fun RQ.doExecute()
}