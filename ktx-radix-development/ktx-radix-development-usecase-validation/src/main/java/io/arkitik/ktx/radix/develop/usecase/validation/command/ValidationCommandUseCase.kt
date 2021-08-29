package io.arkitik.ktx.radix.develop.usecase.validation.command

import io.arkitik.ktx.radix.develop.usecase.actionable.ActionableCommandUseCase
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.ktx.radix.develop.usecase.validation.func.DefaultUseCaseValidator
import io.arkitik.ktx.radix.develop.usecase.validation.func.UseCaseValidator
import io.arkitik.ktx.radix.develop.usecase.validation.validate

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
abstract class ValidationCommandUseCase<RQ : UseCaseRequest>(
    private val validator: UseCaseValidator = DefaultUseCaseValidator(),
) : ActionableCommandUseCase<RQ>() {

    final override fun RQ.before() = (validator validate this).also {
        doBefore()
    }

    override fun RQ.after(response: Unit) {
        // DO NOTHING
    }

    open fun RQ.doBefore() {

    }
}