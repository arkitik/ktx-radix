package io.quee.ktx.radix.usecase.reactive.command

import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [Quee.IO]
 */

infix fun <RQ : UseCaseRequest> ReactiveFluxCommandUseCase<RQ>.execute(request: RQ) =
    listOf(request).toFlux().execute()

infix fun <RQ : UseCaseRequest> ReactiveMonoCommandUseCase<RQ>.execute(request: RQ) =
    request.toMono().execute()