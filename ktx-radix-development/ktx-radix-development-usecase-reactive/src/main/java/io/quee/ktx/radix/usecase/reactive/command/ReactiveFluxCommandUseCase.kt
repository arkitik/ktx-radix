package io.quee.ktx.radix.usecase.reactive.command

import io.quee.ktx.radix.develop.usecase.CommandUseCase
import io.quee.ktx.radix.develop.usecase.adapter.RequestAdapter
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import reactor.core.publisher.Flux

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [https://quee.io]
 */
interface ReactiveFluxCommandUseCase<RQ : UseCaseRequest> : CommandUseCase<RequestAdapter<Flux<RQ>>>