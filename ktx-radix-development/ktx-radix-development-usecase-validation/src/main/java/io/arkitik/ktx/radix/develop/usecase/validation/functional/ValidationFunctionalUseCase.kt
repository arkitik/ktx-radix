package io.arkitik.ktx.radix.develop.usecase.validation.functional

import io.arkitik.ktx.radix.develop.usecase.actionable.ActionableFunctionalUseCase
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseResponse
import io.arkitik.ktx.radix.develop.usecase.validation.func.DefaultUseCaseValidator
import io.arkitik.ktx.radix.develop.usecase.validation.func.UseCaseValidator
import io.arkitik.ktx.radix.develop.usecase.validation.validate

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
abstract class ValidationFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse>(
    private val validator: UseCaseValidator = DefaultUseCaseValidator(),
) : ActionableFunctionalUseCase<RQ, RS>() {

    final override fun RQ.before() = (validator validate this).also {
        doBefore()
    }

    override fun RQ.after(response: RS) {
        // DO NOTHING
    }

    open fun RQ.doBefore() {

    }
}