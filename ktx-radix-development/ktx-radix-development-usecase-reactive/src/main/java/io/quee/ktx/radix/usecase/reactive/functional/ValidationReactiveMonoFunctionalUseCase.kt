package io.quee.ktx.radix.usecase.reactive.functional

import io.quee.ktx.radix.develop.usecase.actionable.Actionable
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse
import io.quee.ktx.radix.develop.usecase.validation.func.DefaultUseCaseValidator
import io.quee.ktx.radix.develop.usecase.validation.func.UseCaseValidator
import io.quee.ktx.radix.develop.usecase.validation.validate
import reactor.core.publisher.Mono

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [Quee.IO]
 */
abstract class ValidationReactiveMonoFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse>(
    private val validator: UseCaseValidator = DefaultUseCaseValidator.create()
) : ReactiveMonoFunctionalUseCase<RQ, RS>, Actionable<RQ, RS> {
    final override fun RQ.before() = validator validate this

    override fun RQ.after(response: RS) = Unit

    final override fun Mono<RQ>.process() =
        with(this) {
            this.map {
                it.apply { before() }
            }.doProcess()
        }

    abstract fun Mono<RQ>.doProcess(): Mono<RS>
}