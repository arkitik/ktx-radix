package io.arkitik.ktx.radix.usecase.reactive.functional

import io.arkitik.ktx.radix.develop.usecase.FunctionalUseCase
import io.arkitik.ktx.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.ktx.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.ktx.radix.develop.usecase.model.UseCaseResponse
import reactor.core.publisher.Flux

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface ReactiveFluxFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> :
    FunctionalUseCase<RequestAdapter<Flux<RQ>>, ResponseAdapter<Flux<RS>>>