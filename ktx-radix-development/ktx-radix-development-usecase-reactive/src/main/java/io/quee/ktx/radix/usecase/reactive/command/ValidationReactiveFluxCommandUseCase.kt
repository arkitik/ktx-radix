package io.quee.ktx.radix.usecase.reactive.command

import io.quee.ktx.radix.develop.usecase.actionable.Actionable
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.validation.func.DefaultUseCaseValidator
import io.quee.ktx.radix.develop.usecase.validation.func.UseCaseValidator
import io.quee.ktx.radix.develop.usecase.validation.validate
import reactor.core.publisher.Flux

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [Quee.IO]
 */
abstract class ValidationReactiveFluxCommandUseCase<RQ : UseCaseRequest>(
    private val validator: UseCaseValidator = DefaultUseCaseValidator.create()
) : ReactiveFluxCommandUseCase<RQ>, Actionable<RQ, Unit> {
    final override fun RQ.before() = validator validate this

    override fun RQ.after(response: Unit) = Unit

    final override fun Flux<RQ>.execute() =
        with(this) {
            this.map {
                it.apply { before() }
            }.doExecute()
        }

    abstract fun Flux<RQ>.doExecute()
}