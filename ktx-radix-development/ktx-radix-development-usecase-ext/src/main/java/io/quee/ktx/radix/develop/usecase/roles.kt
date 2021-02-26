package io.quee.ktx.radix.develop.usecase

import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.validation.func.DefaultUseCaseValidator
import io.quee.ktx.radix.develop.usecase.validation.validate

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 26, **Fri February, 2021**
 * Project *ktx-radix* [Quee.IO]
 */
object JavaXValidator : (UseCaseRequest) -> Unit {
    private val useCaseValidator = DefaultUseCaseValidator.create()
    override fun invoke(p1: UseCaseRequest) =
        useCaseValidator.run {
            validate(p1)
        }
}