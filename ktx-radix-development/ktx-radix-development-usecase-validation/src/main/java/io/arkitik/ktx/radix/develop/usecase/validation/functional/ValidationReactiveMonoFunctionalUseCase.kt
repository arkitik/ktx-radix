package io.arkitik.ktx.radix.develop.usecase.validation.functional

import io.arkitik.ktx.radix.develop.usecase.actionable.Actionable
import io.arkitik.ktx.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.ktx.radix.develop.usecase.adapter.toResponse
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseResponse
import io.arkitik.ktx.radix.develop.usecase.validation.func.DefaultUseCaseValidator
import io.arkitik.ktx.radix.develop.usecase.validation.func.UseCaseValidator
import io.arkitik.ktx.radix.develop.usecase.validation.validate
import io.arkitik.ktx.radix.usecase.reactive.functional.ReactiveMonoFunctionalUseCase
import reactor.core.publisher.Mono

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [https://arkitik.io]
 */
abstract class ValidationReactiveMonoFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse>(
    private val validator: UseCaseValidator = DefaultUseCaseValidator.create(),
) : ReactiveMonoFunctionalUseCase<RQ, RS>, Actionable<RQ, RS> {
    final override fun RQ.before() = validator validate this

    override fun RQ.after(response: RS) = Unit
    final override fun RequestAdapter<Mono<RQ>>.process() =
        with(request) {
            toResponse {
                map {
                    it.apply { before() }
                }.doProcess()
            }
        }

    abstract fun Mono<RQ>.doProcess(): Mono<RS>
}