package io.quee.ktx.radix.develop.usecase.validation

import io.quee.ktx.radix.develop.usecase.actionable.ActionableFunctionalUseCase
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse
import io.quee.ktx.radix.develop.usecase.validation.func.DefaultUseCaseValidator
import io.quee.ktx.radix.develop.usecase.validation.func.UseCaseValidator

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
abstract class ValidationFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse>(
        private val validator: UseCaseValidator = DefaultUseCaseValidator()
) : ActionableFunctionalUseCase<RQ, RS>() {

    final override fun RQ.before() = validator validate this

    override fun RQ.after(response: RS) {
        // DO NOTHING
    }
}