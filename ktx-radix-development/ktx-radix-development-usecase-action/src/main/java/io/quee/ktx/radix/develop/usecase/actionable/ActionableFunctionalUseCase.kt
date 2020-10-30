package io.quee.ktx.radix.develop.usecase.actionable

import io.quee.ktx.radix.develop.usecase.FunctionalUseCase
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
abstract class ActionableFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> : FunctionalUseCase<RQ, RS>, Actionable<RQ, RS> {
    final override fun RQ.process() =
            with(this) {
                before()
                doProcess().also {
                    after(it)
                }
            }

    abstract fun RQ.doProcess(): RS
}