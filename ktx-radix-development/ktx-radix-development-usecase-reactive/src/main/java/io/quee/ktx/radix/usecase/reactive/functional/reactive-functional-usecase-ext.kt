package io.quee.ktx.radix.usecase.reactive.functional

import io.quee.ktx.radix.develop.usecase.adapter.adapterProcess
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [https://quee.io]
 */

infix fun <RQ : UseCaseRequest, RS : UseCaseResponse> ReactiveFluxFunctionalUseCase<RQ, RS>.process(request: RQ) =
    this process listOf(request)

infix fun <RQ : UseCaseRequest, RS : UseCaseResponse> ReactiveFluxFunctionalUseCase<RQ, RS>.process(request: Iterable<RQ>) =
    adapterProcess(request.toFlux())

infix fun <RQ : UseCaseRequest, RS : UseCaseResponse> ReactiveMonoFunctionalUseCase<RQ, RS>.process(request: RQ) =
    adapterProcess(request.toMono())